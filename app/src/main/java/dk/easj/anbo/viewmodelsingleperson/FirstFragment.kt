package dk.easj.anbo.viewmodelsingleperson

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import dk.easj.anbo.viewmodelsingleperson.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val viewModel: PersonViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.personLiveData.observe(viewLifecycleOwner, {
            binding.textviewHello.text = "Hello " + it.name + " " + it.age
        })

        binding.buttonGreet.setOnClickListener {
            val name = binding.nameEditText.text.trim().toString()
            if (name.isEmpty()) {
                binding.nameEditText.error = "No name"
                return@setOnClickListener
            }
            val ageStr = binding.ageEditText.text.trim().toString()
            if (ageStr.isEmpty()) {
                binding.ageEditText.error = "No age"
                return@setOnClickListener
            }

            viewModel.personLiveData.value = Person(name, ageStr.toInt())
        }

        binding.buttonNext.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}