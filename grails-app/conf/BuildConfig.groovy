grails.project.work.dir = "target/work"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    legacyResolve true // whether to do a secondary resolve on plugin installation, not advised but set here for backwards compatibility
    repositories {
        grailsCentral()
        mavenCentral()
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
        runtime ("org.postgresql:postgresql:9.2-1004-jdbc3") {
            export = false
        }
    }

    plugins {
        build(":tomcat:$grailsVersion",
              ":release:2.2.0",
              ":rest-client-builder:1.0.3") {
            export = false
        }

        test (":spock:0.7",
              ":code-coverage:1.2.6") {
            export = false
        }

        compile (":guard:1.0.7") {
            export = false
        }

        runtime (":hibernate:$grailsVersion") {
            export = false
        }
    }
}
