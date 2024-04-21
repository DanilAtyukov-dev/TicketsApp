plugins {

    alias(libs.plugins.jetbrainsKotlinJvm)
}
dependencies {
    implementation(project(":domain"))

    implementation(libs.retrofit)
    implementation(libs.converter.gson)
}

