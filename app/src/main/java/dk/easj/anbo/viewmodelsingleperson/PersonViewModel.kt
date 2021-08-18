package dk.easj.anbo.viewmodelsingleperson

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PersonViewModel : ViewModel() {
    val personLiveData: MutableLiveData<Person> = MutableLiveData()
}