

job("Build and push Docker") {
    docker {

        build {
            context = "docker"
            file = "./Dockerfile"
            args["HTTP_PROXY"] = "http://10.20.30.2:1234"
            labels["vendor"] = "netmoor"
        }

        push("netmoor.registry.jetbrains.space/p/edu/containers/hazelcast-demo") {
            // use current job run number as a tag - '0.0.run_number'
            tags("0.0.\$JB_SPACE_EXECUTION_NUMBER")
            // see example on how to use branch name in a tag
        }
    }
}