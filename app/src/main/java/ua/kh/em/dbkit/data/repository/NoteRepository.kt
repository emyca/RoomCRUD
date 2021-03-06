package ua.kh.em.dbkit.data.repository

import androidx.lifecycle.LiveData
import ua.kh.em.dbkit.data.model.Note
import ua.kh.em.dbkit.data.database.NoteDao


class NoteRepository (private val noteDao: NoteDao){

    private var noteList: LiveData<List<Note>>? = null

    fun readAllNotes(): LiveData<List<Note>> {
        noteList = noteDao.readAllNotes()
        return noteList as LiveData<List<Note>>
    }

    fun readSearch(search: String?): LiveData<List<Note>> {
        noteList = noteDao.readSearch(search)
        return noteList as LiveData<List<Note>>
    }

    suspend fun insertNote(note: Note){
        noteDao.insertNote(note)
    }

//    replaced with updateData()
//    suspend fun updateNote(note: Note){
//        noteDao.updateNote(note)
//    }

    suspend fun updateData(name: String, content: String, id: Int) {
        noteDao.updateData(name, content, id)
    }

    suspend fun deleteNote(note: Note){
        noteDao.deleteNote(note)
    }


}