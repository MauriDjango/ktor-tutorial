import com.example.dao.DAOArticle
import com.example.dao.DAOSubject
import com.example.models.Article
import com.example.models.Subject
import kotlinx.coroutines.runBlocking


val daoArticle: DAOArticle = DAOArticle().apply {
    runBlocking {
        if(all().isEmpty()) {
            add(
                Article(
                    id = 1,
                    title = "The drive to develop!",
                    body = "...it's what keeps me going."
                )
            )
        }
    }
}

val daoSubject: DAOSubject = DAOSubject().apply {
    runBlocking {
        if(all().isEmpty()) {
            add(
                Subject(
                    "Default",
                    "None",
                    "Generic",
                    "No subjects have been found",
                    1,
                    0,
                )
            )
        }
    }
}