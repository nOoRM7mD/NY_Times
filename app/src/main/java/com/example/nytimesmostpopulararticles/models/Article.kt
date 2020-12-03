package com.example.nytimesmostpopulararticles.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
    val id: Long?,
    val url: String?,
    val adxKeywords: String?,
    val column: String?,
    val byline: String?,
    val type: String?,
    val title: String?,
    val abstract: String?,
    val publishedDate: String?,
    val source: String?,
    val assetId: Long?,
    val views: Int?,
    val desFacet: List<String>?,
    val orgFacet: List<String>?,
    val perFacet: List<String>?,
    val geoFacet: List<String>?,
    val media: List<Media>?,
    val uri: String?

) : Parcelable


@Parcelize
data class Media(
    val type: String?,
    val subtype: String?,
    val caption: String?,
    val copyright: String?,
    val approved_for_syndication: String?,
    @SerializedName("media-metadata")
    val mediaMetadata: List<MediaMetaData>
) : Parcelable


@Parcelize
data class MediaMetaData(
    val url: String?,
    val format: String?,
    val height: Int?,
    val width: Int?
) : Parcelable

