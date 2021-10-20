package com.example.xmlrssfeedandhttpurlconnections.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "entry", strict = false)
class Entry @JvmOverloads constructor(

    @field:Element
    @param:Element(name = "author")
    var author: Author? = null,

    @field:Element
    @param:Element(name = "title")
    var title: String? = null,
) : Serializable {}