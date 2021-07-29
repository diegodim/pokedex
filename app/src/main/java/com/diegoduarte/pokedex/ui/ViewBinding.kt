package com.diegoduarte.pokedex.ui.pokedex.view



import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.Downsampler
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.diegoduarte.pokedex.R
import com.diegoduarte.pokedex.data.model.Pokemon
import com.diegoduarte.pokedex.utils.ApiStatus
import com.diegoduarte.pokedex.utils.toUpperCase
import com.google.android.material.appbar.CollapsingToolbarLayout


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Pokemon>?) {
    if(data != null) {
        val adapter = recyclerView.adapter as PokedexAdapter
        adapter.submitList(data)
    }

}


@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, id: Int) {
    id.let {
        val url = imgView.context.getString(R.string.url_image, it)
        Glide.with(imgView.context)
            .load(url)
            .centerInside()
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .set(Downsampler.DECODE_FORMAT, DecodeFormat.PREFER_RGB_565)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imgView)
    }

}

@BindingAdapter("nameText")
fun TextView.bindTextTitle(name: String) {
    name.let {
        text = toUpperCase(it)
    }
}

@BindingAdapter("idText")
fun TextView.bindTextId(id: Int) {
    id.let {
        text = this.context.getString(R.string.display_id,it.toString().padStart(3,'0'))
    }
}

@BindingAdapter("colorCardView")
fun bindColorCardView(cardView: CardView, pokemon: Pokemon) {
    pokemon.color.let {
        cardView.setCardBackgroundColor(cardView.context.getColor(it))

    }
}
@BindingAdapter("colorView")
fun bindColorView(view: View, pokemon: Pokemon) {
    pokemon.color.let {
        view.setBackgroundColor(view.context.getColor(it))

    }
}

@BindingAdapter("colorContent")
fun bindContent(view: CollapsingToolbarLayout, pokemon: Pokemon) {
    pokemon.name!!.english.let {
        view.title = toUpperCase(it)
    }
    pokemon.color.let {
        view.setContentScrimColor( view.context.getColor(it))

    }
}

@BindingAdapter("type1Text")
fun TextView.bindTextType1(pokemon: Pokemon) {
    pokemon.type?.let { types ->
        if (types.isNotEmpty()) {
            text = toUpperCase(types[0])
            visibility = View.VISIBLE

        } else visibility = View.GONE
    }
}

@BindingAdapter("type2Text")
fun TextView.bindTextType2(pokemon: Pokemon) {
    pokemon.type?.let { types ->
        if (types.size >= 2) {
            text = toUpperCase(types[1])
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


