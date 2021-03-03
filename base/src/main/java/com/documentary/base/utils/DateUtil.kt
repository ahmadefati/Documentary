package com.documentary.base.utils

import saman.zamani.persiandate.PersianDate
import saman.zamani.persiandate.PersianDateFormat
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.abs

@Singleton
class DateUtil @Inject constructor() {

    private val persianDateFormat = PersianDateFormat("Ymd")

    private val persianDate = PersianDate()

    fun toDateView(date: String?): String {
        return if (!date.equals("null") || !date.equals("")) {
            date?.let {
                "${date.substring(0, 4)}/${date.substring(4, 6)}/${
                    date.substring(
                        6,
                        8
                    )
                }"
            }
                ?: ""
        } else "-"
    }

    fun toDateViewWhitoutYear(date: String?): String {
        return if (!date.equals("null")) {
            date?.let {
                "${date.substring(4, 6)}/${
                    date.substring(
                        6,
                        8
                    )
                }"
            }
                ?: ""
        } else "-"
    }

    private fun toDateViewWhitDash(date: String?): String {
        return if (!date.equals("null") || !date.equals("")) {
            date?.let {
                "${date.substring(0, 4)}-${date.substring(4, 6)}-${
                    date.substring(
                        6,
                        8
                    )
                }"
            }
                ?: ""
        } else
            ""
    }

    fun toTimeView(time: String?): String {

        return time?.let {
            if (time.length > 5) "${time.substring(0, 2)}:${time.substring(2, 4)}:${
                time.substring(
                    4,
                    6
                )
            }" else "-"
        }
            ?: ""
    }

    fun isToday(date: String): Boolean {
        return persianDateFormat.format(persianDate) == date
    }

    fun getToday(): String {
        return persianDateFormat.format(persianDate)
    }

    fun addMonth(month: Int): PersianDate {
        return persianDate.addMonth(month.toLong())
    }

    fun differenceOfDates(date1: String, date2: String): Int? {
        val differenceYear: Int
        val differenceMonth: Int
        var a: Int
        if (date1 != "null" && date2 != "null") {
            val pDate1 = persianDateFormat.parse(toDateViewWhitDash(date1), "yyyy-MM-dd")
            val pDate2 = persianDateFormat.parse(toDateViewWhitDash(date2), "yyyy-MM-dd")
            var year1 = pDate1.shYear
            var year2 = pDate2.shYear
            var month1 = pDate1.shMonth
            var month2 = pDate2.shMonth

            //for get Late date
            if (year1 > year2) {
                a = year2
                year2 = year1
                year1 = a
                a = month2
                month2 = month1
                month1 = a
            }
            if (year1 == year2) {
                differenceMonth = abs(month2 - month1)
            } else {
                differenceYear = year2 - year1
                differenceMonth = differenceYear * 12 + (month2 - month1)
            }
            return differenceMonth
        } else return null
    }

    fun dateDifferenceToDate(date1: String?): Int {
        return if (date1 != null) {
            when (date1.length) {
                8 -> {
                    val pDate1 = persianDateFormat.parse(toDateViewWhitDash(date1), "yyyy-MM-dd")
                    pDate1.dayuntilToday.toInt()
                }
                10 -> {
                    val pDate1 = persianDateFormat.parse(date1, "yyyy/MM/dd")
                    pDate1.dayuntilToday.toInt()
                }
                else -> 0
            }
        } else 0
    }

    fun addDay(value: Int): String {
        val persianDateToday = PersianDate()
        return persianDateFormat.format(persianDateToday.addDay(value.toLong()))
    }

    fun addYear(value: Int): String {
        val persianDateToday = PersianDate()
        return persianDateFormat.format(persianDateToday.addYear(value.toLong()))
    }

    fun addYearToPersianDate(value: Int): PersianDate {
        val date = PersianDate()
        date.shYear = date.shYear + value
        return date
    }
}