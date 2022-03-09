package ir.mohammadhf.alibabainternationaltask.data.model

import com.squareup.moshi.Json

data class Response(

    @field:Json(name="per_page")
	val perPage: Int,

    @field:Json(name="total")
	val total: Int,

    @field:Json(name="data")
	val data: List<User>,

    @field:Json(name="page")
	val page: Int,

    @field:Json(name="total_pages")
	val totalPages: Int,

    @field:Json(name="support")
	val support: Support
)