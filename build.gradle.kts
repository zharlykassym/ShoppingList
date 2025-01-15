// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.6.1" apply false
    id("org.jetbrains.kotlin.android") version "2.1.0" apply false
    id("com.google.devtools.ksp") version "2.1.0-1.0.29"
    kotlin("kapt") version "2.1.0"


}

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {

//        implementation("com.google.dagger:dagger-compiler:2.52")
//        ksp("com.google.dagger:dagger-compiler:2.52")

    }
}
