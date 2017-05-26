package br.com.felipeacerbi.keddit.models

import android.os.Parcel
import android.os.Parcelable
import br.com.felipeacerbi.keddit.utils.createParcel

/**
 * Created by felipe.acerbi on 26/05/2017.
 */
data class RedditNews(
        val after: String,
        val before: String,
        val news: List<RedditNewsItem>
) : Parcelable {

    companion object {
        @JvmField
        val CREATOR = createParcel { RedditNews(it) }
    }

    protected constructor(parcelIn: Parcel) : this(
            parcelIn.readString(),
            parcelIn.readString(),
            mutableListOf<RedditNewsItem>().apply {
                parcelIn.readTypedList(this, RedditNewsItem.CREATOR)
            }
    )

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(after)
        dest.writeString(before)
        dest.writeTypedList(news)
    }

    override fun describeContents(): Int = 0

}