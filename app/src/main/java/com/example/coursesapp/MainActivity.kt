package com.example.coursesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.coursesapp.data.DataSource
import com.example.coursesapp.model.Topic
import com.example.coursesapp.ui.theme.CoursesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicsApp()
                }
            }
        }
    }
}

@Composable
fun TopicsApp() {
   TopicsList(topicList = DataSource().loadTopics())
}

@Composable
fun TopicsList(topicList: List<Topic>,modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
            items(topicList) {topic ->
                TopicCard(topic = topic)
           }
        }
    }


@Composable
fun TopicCard (topic: Topic, modifier: Modifier = Modifier) {
    Card (modifier = modifier) {
        Row {
        Image(
            painter = painterResource(topic.imageResourceId),
            contentDescription = stringResource(topic.stringResourceId))
        Column {
            Text(text = stringResource(topic.stringResourceId))
            Text(text = topic.classes.toString())
        }
    }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoursesAppTheme {
        TopicCard(Topic(R.string.architecture, 54, R.drawable.architecture))
    }
}