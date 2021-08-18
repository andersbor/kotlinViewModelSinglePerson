package dk.easj.anbo.viewmodelsingleperson

import java.io.Serializable

class Person(var name: String, var age: Int) : Serializable {
    override fun toString(): String {
        return "$name $age"
    }

}