package com.dicoding.edujourney

import com.dicoding.edujourney.core.source.remote.response.CourseResponse

object DummyCourse {

    private var id = arrayOf(
        "s1", "s2", "s3", "s4", "h1", "h2", "h3", "h4"
    )

    private var img = arrayOf(
        "https://www.freepik.com/free-vector/work-chat-concept-illustration_7118068.htm#page=1&query=communication&position=22",
        "https://www.freepik.com/free-icon/office_14840978.htm#page=1&query=microsoft%20office&position=7",
        "https://www.freepik.com/free-vector/you-speak-english-lettering-background_2619959.htm#page=1&query=english&position=2",
        "https://www.freepik.com/free-vector/computer-monitor-graphic-animator-creating-video-game-modeling-motion-processing-video-file-using-professional-editor-vector-illustration-graphic-design-art-designer-workplace-concept_11671412.htm#page=1&query=computer&position=0",
        "https://www.freepik.com/free-vector/wall-post-concept-illustration_7769804.htm#page=1&query=copywriting&position=1",
        "https://www.freepik.com/free-vector/web-development-programmer-engineering-coding-website-augmented-reality-interface-screens-developer-project-engineer-programming-software-application-design-cartoon-illustration_10798281.htm#page=1&query=web%20development&position=1",
        "https://www.freepik.com/free-vector/accountant-concept-illustration_13766143.htm#page=1&query=accounting&position=0",
        "https://www.freepik.com/free-vector/graphic-design-colorful-geometrical-lettering_7088583.htm#page=1&query=graphic%20design&position=49"
    )
    private var title = arrayOf(
        "Communication",
        "Ms.Office",
        "English",
        "Computer Operation",
        "CopyWriting",
        "Web Development",
        "Accounting",
        "Graphic Design"
    )

    private var description = arrayOf(
        "In this course you will learn about professional communication that will be needed in your career",
        "In this course you will learn how to use basic Ms.Office such as Ms.Word, Ms.Excel, etc",
        "English course that everyone needs in their career path",
        "Computer operation is important if you willing to work in the office",
        "Copywriting is one of the art of writing techniques and the goal is to get a response from the reader. Copywriters are highly sought after by companies",
        "Becoming Web Developer is a biggest chance to play a part in technology",
        "When you tell your friends that you’ve signed up for an accounting class, you’ll likely get a reaction that sounds something like this: \"Ugh, why?\" Or, perhaps they will be slightly more sympathetic and say, \"Oh, sorry to hear that.\"\n" +
                "\n" +
                "Accounting gets a bad rap, but it's an incredibly useful subject to learn. Plus, it's not as complicated as you might think! Hear me out—here are four reasons why everyone can benefit from understanding basic accounting.",
        "Reasons why you should study Graphic Design\n" +
                "\n" +
                "Plenty of job opportunities\n" +
                "2.Make your work score on the world\n" +
                "\n" +
                "3.No days are the same\n" +
                "\n" +
                "4. Work across multiple Industries\n" +
                "\n" +
                "5. Graphic designers have a fun work environment\n" +
                "\n" +
                "6. Get paid for being a productive designer"
    )

    private var price = intArrayOf(
        0,
        0,
        50000,
        0,
        250000,
        200000,
        60000,
        0
    )

    private var module = arrayOf(
        "Module 1",
        "Module 2",
        "Module 3",
        "Module 4",
        "Module 5"
    )

    private var type = arrayOf(
        "SOFT",
        "SOFT",
        "SOFT",
        "SOFT",
        "HARD",
        "HARD",
        "HARD",
        "HARD"
    )

    private var recommended = arrayOf(
        true,
        false,
        true,
        true,
        true,
        true,
        false,
        false
    )
    val listData: ArrayList<CourseResponse>
    get(){
        val list = arrayListOf<CourseResponse>()
        for(position in id.indices){
            list.add(CourseResponse(
                courseId = id[position],
                image = img[position],
                title = title[position],
                description = description[position],
                type = type[position],
                price = price[position],
                recommended = recommended[position],
            ))
        }
        return list
    }

}