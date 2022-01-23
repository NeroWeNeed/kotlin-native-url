plugins {
    kotlin("multiplatform") version "1.6.10"
}

group = "github.nwn"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvm()
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
    }
}

tasks.register<CodeGenerationTask>("urlFactoryCodeGenerator") {
    generator = URLFactoryGenerator::class.qualifiedName!!
    className = "DefaultUrlFactory"
    classPackage = "github.nwn.commons"
    sourceSet = "commonMain"

}