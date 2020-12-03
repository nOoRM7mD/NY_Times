package com.example.nytimesmostpopulararticles.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class MostPopularArticlesModel(
    val copyright: String?,
    val num_results: Int?,
    val results: List<Article>?,
    val status: String?
)

@Parcelize
data class Article(
    val `abstract`: String?,
    val adx_keywords: String?,
    val asset_id: Long?,
    val byline: String?,
    val column: String?,
    val des_facet: List<String>?,
    val eta_id: Int?,
    val geo_facet: List<String>?,
    val id: Long?,
    val media: List<Media>?,
    val nytdsection: String?,
    val org_facet: List<String>?,
    val per_facet: List<String>?,
    val published_date: String?,
    val section: String?,
    val source: String?,
    val subsection: String?,
    val title: String?,
    val type: String?,
    val updated: String?,
    val uri: String?,
    val url: String?
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

