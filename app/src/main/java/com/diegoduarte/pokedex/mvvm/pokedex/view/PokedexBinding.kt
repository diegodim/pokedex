package com.diegoduarte.pokedex.mvvm.pokedex.view


import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.resource.bitmap.Downsampler
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.diegoduarte.pokedex.R
import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.utils.ApiStatus
import com.diegoduarte.pokedex.utils.toUpperCase


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Pokemon>?) {
    if(data != null) {
        val adapter = recyclerView.adapter as PokedexAdapter
        adapter.submitList(data)
    }

}


@BindingAdapter("imageUrl")
fun bindItemImage(imgView: ImageView, id: Int) {
    id.let {
        val imgUrl = imgView.context.getString(R.string.url_image, it)

        Glide.with(imgView.context)
            .load(imgUrl)
            .centerInside()
            .set(Downsampler.DECODE_FORMAT, DecodeFormat.PREFER_RGB_565)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imgView)
    }
}

@BindingAdapter("nameText")
fun TextView.bindItemTextTitle(name: String) {
    name.let {
        text = toUpperCase(it)
    }
}

@BindingAdapter("idText")
fun TextView.bindItemTextId(id: Int) {
    id.let {
        text = "#"+it.toString().padStart(4,'0')
    }
}

@BindingAdapter("colorCardView")
fun bindItemCardView(cardView: CardView, pokemon: Pokemon) {
    pokemon.types[0].type.color.let {
        cardView.setCardBackgroundColor(cardView.context.getColor(it))

    }
}

@BindingAdapter("type1Text")
fun TextView.bindItemTextType1(pokemon: Pokemon) {
    pokemon.types.let { types ->
        if (types.isNotEmpty()) {
            text = toUpperCase(types[0].type.name)
            visibility = View.VISIBLE

        } else visibility = View.GONE
    }
}

@BindingAdapter("type2Text")
fun TextView.bindItemTextType2(pokemon: Pokemon) {
    pokemon.types.let { types ->
        if (types.size >= 2) {
            text = toUpperCase(types[1].type.name)
            visibility = View.VISIBLE

        } else visibility = View.GONE
    }
}


@BindingAdapter("apiStatusLoading")
fun bindStatusLoading(view: View, status: ApiStatus?) {
    when (status) {
        ApiStatus.LOADING -> {
            view.visibility = View.VISIBLE
        }
        ApiStatus.ERROR -> {
            view.visibility = View.GONE
        }
        ApiStatus.DONE -> {
            view.visibility = View.GONE
        }
    }
}


@BindingAdapter("apiStatusDone")
fun bindStatusDone(view: View, status: ApiStatus?) {
    when (status) {
        ApiStatus.LOADING -> {
            view.visibility = View.GONE
        }
        ApiStatus.ERROR -> {
            view.visibility = View.GONE
        }
        ApiStatus.DONE -> {
            view.visibility = View.VISIBLE
        }
    }
}


