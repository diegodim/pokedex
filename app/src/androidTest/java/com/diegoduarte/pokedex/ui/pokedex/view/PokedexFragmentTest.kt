package com.diegoduarte.pokedex.ui.pokedex.view

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isRoot
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.diegoduarte.pokedex.DaggerTestApplicationRule
import com.diegoduarte.pokedex.R
import com.diegoduarte.pokedex.data.model.Name
import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.data.model.Profile
import com.diegoduarte.pokedex.data.model.Stats
import com.diegoduarte.pokedex.data.source.FakeTestAndroidRepository
import com.diegoduarte.pokedex.data.source.PokedexRepository
import com.diegoduarte.pokedex.ui.MainActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.LooperMode
import org.robolectric.annotation.TextLayoutMode


@RunWith(AndroidJUnit4::class)
@MediumTest
@LooperMode(LooperMode.Mode.PAUSED)
@TextLayoutMode(TextLayoutMode.Mode.REALISTIC)
@ExperimentalCoroutinesApi
class PokedexFragmentTest {



    private lateinit var repository: PokedexRepository

    @get:Rule
    val rule = DaggerTestApplicationRule()

    @Before
    fun setupDaggerComponent() {
        repository = rule.component.pokedexRepository
        (repository as FakeTestAndroidRepository).deletePokemon()

    }

    @Test
    fun displayPokemon_whenRepositoryHasData() {
        (repository as FakeTestAndroidRepository).addPokemon(
            Pokemon(
                id = 1,
                name = Name("Henrique"),
                type = listOf("Grass", "Poison"),
                base = Stats(1,1,1,1,1,1),
                profile = Profile("","")
            ))

        launchActivity()
        //onView(ViewMatchers.withText("Henrique")).perform(ViewActions.click())
        //onView(isRoot()).perform(ViewActions.pressBack());
        onView(ViewMatchers.withText("Henrique"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }

    private fun launchActivity(): ActivityScenario<MainActivity>? {
        val activityScenario = launch(MainActivity::class.java)
        activityScenario.onActivity { activity ->
            // Disable animations in RecyclerView
            (activity.findViewById(R.id.pokedex_list) as RecyclerView).itemAnimator = null
        }
        return activityScenario
    }

}