package com.alexander.parco.lab08.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DefaultItemAnimator
import com.alexander.parco.lab08.adapter.PokemonAdapter
import com.alexander.parco.lab08.data.models.payload.PokemonResponse
import com.alexander.parco.lab08.databinding.ActivityMainBinding
import com.alexander.parco.lab08.ui.viewmodel.MainViewModel
import com.yuyakaido.android.cardstackview.*

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate),
    CardStackListener,
    PokemonAdapter.CallBack{

    private val adapter by lazy { PokemonAdapter(listPokemon, this)}

    private val listPokemon: List<PokemonResponse> = emptyList()

    private val manager by lazy {CardStackLayoutManager(this, this)}

    private val mainViewModel by lazy { MainViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeTinderCard()

        mainViewModel.pokemonList.observe(this) {
            adapter.list = it
            adapter.notifyDataSetChanged()
        }

        mainViewModel.isLoading.observe(this) {
            binding.progressBar.isVisible = it
        }

    }

    private fun initializeTinderCard(){
        manager.setStackFrom(StackFrom.None)
        manager.setVisibleCount(3)
        manager.setTranslationInterval(8.0f)
        manager.setScaleInterval(0.95f)
        manager.setSwipeThreshold(0.3f)
        manager.setMaxDegree(20.0f)
        manager.setDirections(Direction.HORIZONTAL)
        manager.setCanScrollHorizontal(true)
        manager.setCanScrollVertical(true)
        manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
        manager.setOverlayInterpolator(LinearInterpolator())

        binding.rvTinderPokemon.layoutManager = manager

        binding.rvTinderPokemon.adapter = adapter

        binding.rvTinderPokemon.itemAnimator.apply {
            if (this is DefaultItemAnimator){
                supportsChangeAnimations = false
            }
        }
    }

    override fun onClickPokemonInformation(pokemon: PokemonResponse) {
        Toast.makeText(this, "Click Pokemon: ${pokemon.name}", Toast.LENGTH_SHORT).show()
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {
    }

    override fun onCardSwiped(direction: Direction?) {
        if (direction != null){
            Log.e("OnCardSwiped", direction.name)
        }
    }

    override fun onCardRewound() {
    }

    override fun onCardCanceled() {
    }

    override fun onCardAppeared(view: View?, position: Int) {
    }

    override fun onCardDisappeared(view: View?, position: Int) {
    }

}