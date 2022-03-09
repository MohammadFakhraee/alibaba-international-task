package ir.mohammadhf.alibabainternationaltask.data.model

import com.squareup.moshi.Json

data class Support(

	@field:Json(name="text")
	val text: String,

	@field:Json(name="url")
	val url: String
)