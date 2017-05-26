package br.com.felipeacerbi.keddit.models

import android.os.Parcel
import android.os.Parcelable
import br.com.felipeacerbi.keddit.adapters.utils.AdapterConstants
import br.com.felipeacerbi.keddit.adapters.models.ViewType
import br.com.felipeacerbi.keddit.utils.createParcel

/**
 * Created by feaac on 5/19/2017.
 */
data class RedditNewsItem(
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
) : ViewType, Parcelable {
    override fun getViewType() = AdapterConstants.NEWS

    companion object {
        @JvmField
        val CREATOR = createParcel { RedditNewsItem(it) }
    }

    protected constructor(parcelIn: Parcel) : this(
            parcelIn.readString(),
            parcelIn.readString(),
            parcelIn.readInt(),
            parcelIn.readLong(),
            parcelIn.readString(),
            parcelIn.readString()
    )

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(author)
        dest.writeString(title)
        dest.writeInt(numComments)
        dest.writeLong(created)
        dest.writeString(thumbnail)
        dest.writeString(url)
    }

    override fun describeContents(): Int = 0
}