package com.feng.jetpack.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.feng.jetpack.room.Person
import com.feng.jetpack.room.PersonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RoomViewModel(application: Application) : AndroidViewModel(application) {
    private val personRepository: PersonRepository = PersonRepository(application)
    val persons: MutableLiveData<List<Person>> = MutableLiveData<List<Person>>().apply {
        value = personRepository.allPerson
    }

    fun insert(person: Person) {
        viewModelScope.launch(Dispatchers.IO) {
            personRepository.insert(person)
            withContext(Dispatchers.Main) {
                persons.value = personRepository.allPerson
            }
        }
    }

    fun clear() {
        viewModelScope.launch(Dispatchers.IO) {
            personRepository.clear()
            withContext(Dispatchers.Main) {
                persons.value = personRepository.allPerson
            }
        }
    }
}