package com.example.lookatyourself.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

data class LookAtYourselfTypography(
    //region Number
    val numbers0MediumDefault: TextStyleThemeDefault = TextStyleThemeDefault(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 44.sp,
        lineHeight = 48.sp,
        letterSpacing = 0.33.sp,
    ),
    val numbers0Medium: TextStyle = numbers0MediumDefault.toTextStyle(),

    val numbers1MediumDefault: TextStyleThemeDefault = TextStyleThemeDefault(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.3.sp,
    ),
    val numbers1Medium: TextStyle = numbers1MediumDefault.toTextStyle(),

    val numbers2MediumDefault: TextStyleThemeDefault = TextStyleThemeDefault(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 48.sp,
        letterSpacing = 0.3.sp,
    ),
    val numbers2Medium: TextStyle = numbers2MediumDefault.toTextStyle(),

    val numbers2RegularDefault: TextStyleThemeDefault = TextStyleThemeDefault(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.3.sp,
    ),
    val numbers2Regular: TextStyle = numbers2RegularDefault.toTextStyle(),
    //endregion

    //region Title
    val title0SemiboldDefault: TextStyleThemeDefault = TextStyleThemeDefault(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.33.sp,
    ),
    val title0Semibold: TextStyle = title0SemiboldDefault.toTextStyle(),

    val title3SemiboldDefault: TextStyleThemeDefault = TextStyleThemeDefault(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 24.sp,
    ),
    val title3Semibold: TextStyle = title3SemiboldDefault.toTextStyle(),

    val title4SemiboldDefault: TextStyleThemeDefault = TextStyleThemeDefault(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 24.sp,
    ),
    val title4Semibold: TextStyle = title4SemiboldDefault.toTextStyle(),

    val title1BoldDefault: TextStyleThemeDefault = TextStyleThemeDefault(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 32.sp,
    ),
    val title1Bold: TextStyle = title1BoldDefault.toTextStyle(),

    val title2BoldDefault: TextStyleThemeDefault = TextStyleThemeDefault(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 28.sp,
    ),
    val title2Bold: TextStyle = title2BoldDefault.toTextStyle(),

    val title3BoldDefault: TextStyleThemeDefault = TextStyleThemeDefault(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 24.sp,
    ),
    val title3Bold: TextStyle = title3BoldDefault.toTextStyle(),

    val title4BoldDefault: TextStyleThemeDefault = TextStyleThemeDefault(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        lineHeight = 24.sp,
    ),
    val title4Bold: TextStyle = title4BoldDefault.toTextStyle(),

    val title2MediumDefault: TextStyleThemeDefault = TextStyleThemeDefault(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 28.sp,
    ),
    val title2Medium: TextStyle = title2MediumDefault.toTextStyle(),
    //endregion

    //region Text

    val text1RegularDefault: TextStyleThemeDefault = TextStyleThemeDefault(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.33.sp,
    ),
    val text1Regular: TextStyle = text1RegularDefault.toTextStyle(),

    val text2RegularDefault: TextStyleThemeDefault = TextStyleThemeDefault(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.33.sp,
        lineHeight = 16.sp,
    ),
    val text2Regular: TextStyle = text2RegularDefault.toTextStyle(),

    val text3RegularDefault: TextStyleThemeDefault = TextStyleThemeDefault(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.33.sp,
        lineHeight = 16.sp,
    ),
    val text3Regular: TextStyle = text3RegularDefault.toTextStyle(),

    val text1MediumDefault: TextStyleThemeDefault = TextStyleThemeDefault(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.33.sp,
    ),
    val text1Medium: TextStyle = text1MediumDefault.toTextStyle(),

    val text2MediumDefault: TextStyleThemeDefault = TextStyleThemeDefault(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.33.sp,
    ),
    val text2Medium: TextStyle = text2MediumDefault.toTextStyle(),

    val text1SemiboldDefault: TextStyleThemeDefault = TextStyleThemeDefault(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.33.sp,
    ),
    val text1Semibold: TextStyle = text1SemiboldDefault.toTextStyle(),

    val text1SemiboldCapsDefault: TextStyleThemeDefault = TextStyleThemeDefault(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.66.sp,
    ),
    val text1SemiboldCaps: TextStyle = text1SemiboldCapsDefault.toTextStyle(),

    val text2SemiboldDefault: TextStyleThemeDefault = TextStyleThemeDefault(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.33.sp,
    ),
    val text2Semibold: TextStyle = text2SemiboldDefault.toTextStyle(),
    //endregion

    //region Button
    val button1RegularDefault: TextStyleThemeDefault = TextStyleThemeDefault(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 1.25.sp,
    ),
    val button1Regular: TextStyle = button1RegularDefault.toTextStyle(),

    val button1MediumDefault: TextStyleThemeDefault = TextStyleThemeDefault(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 20.sp,
    ),
    val button1Medium: TextStyle = button1MediumDefault.toTextStyle(),
    //endregion

    //region Caption

    val caption1SemiboldCapsDefault: TextStyleThemeDefault = TextStyleThemeDefault(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.66.sp,
    ),
    val caption1SemiboldCaps: TextStyle = caption1SemiboldCapsDefault.toTextStyle(),

    val caption2MediumDefault: TextStyleThemeDefault = TextStyleThemeDefault(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.33.sp,
    ),
    val caption2Medium: TextStyle = caption2MediumDefault.toTextStyle(),

    val caption3MediumDefault: TextStyleThemeDefault = TextStyleThemeDefault(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.33.sp,
    ),
    val caption3Medium: TextStyle = caption3MediumDefault.toTextStyle(),

    val caption3BoldDefault: TextStyleThemeDefault = TextStyleThemeDefault(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.33.sp,
    ),
    val caption3Bold: TextStyle = caption3BoldDefault.toTextStyle(),
    //endregion
)

private fun TextStyleThemeDefault.toTextStyle() = TextStyle(
    color = this.color,
    fontSize = this.fontSize,
    fontWeight = this.fontWeight,
    fontStyle = this.fontStyle,
    fontSynthesis = this.fontSynthesis,
    fontFamily = this.fontFamily,
    fontFeatureSettings = this.fontFeatureSettings,
    letterSpacing = this.letterSpacing,
    baselineShift = this.baselineShift,
    textGeometricTransform = this.textGeometricTransform,
    localeList = this.localeList,
    background = this.background,
    textDecoration = this.textDecoration,
    shadow = this.shadow,
    textAlign = this.textAlign,
    textDirection = this.textDirection,
    lineHeight = this.lineHeight,
    textIndent = this.textIndent,
)

internal val LocalLookAtYourselfTypography = staticCompositionLocalOf { LookAtYourselfTypography() }