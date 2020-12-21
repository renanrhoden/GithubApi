package com.renanrhoden.feature

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.renanrhoden.feature.test", appContext.packageName)
//        listOf(
//                    GithubRepo(
//                        "Repo name 1",
//                        "author name 1",
//                        1,
//                        1,
//                        "https://cdn0.iconfinder.com/data/icons/customicondesignoffice5/256/examples.png"
//                    ),
//                    GithubRepo(
//                        "Repo name 2",
//                        "author name 2",
//                        2,
//                        2,
//                        "https://cdn0.iconfinder.com/data/icons/customicondesignoffice5/256/examples.png"
//                    ),
//                    GithubRepo(
//                        "Repo name 3",
//                        "author name 3",
//                        3,
//                        3,
//                        "https://cdn0.iconfinder.com/data/icons/customicondesignoffice5/256/examples.png"
//                    ),
//                    GithubRepo(
//                        "Repo name 4",
//                        "author name 4",
//                        4,
//                        4,
//                        "https://cdn0.iconfinder.com/data/icons/customicondesignoffice5/256/examples.png"
//                    ),
//                    GithubRepo(
//                        "Repo name 5",
//                        "author name 5",
//                        5,
//                        5,
//                        "https://cdn0.iconfinder.com/data/icons/customicondesignoffice5/256/examples.png"
//                    ),
//                    GithubRepo(
//                        "Repo name 6",
//                        "author name 6",
//                        6,
//                        6,
//                        "https://cdn0.iconfinder.com/data/icons/customicondesignoffice5/256/examples.png"
//                    ),
//                    GithubRepo(
//                        "Repo name 7",
//                        "author name 7",
//                        76,
//                        7,
//                        "https://cdn0.iconfinder.com/data/icons/customicondesignoffice5/256/examples.png"
//                    ),
//                )
    }
}