job("Build and push Docker") {
    docker {
        build {
            context = "docker"
            file = "./Dockerfile"
            labels["vendor"] = "netmoor"
            args["HTTP_PROXY"] = "http://10.20.30.1:123"
        }

        push("netmoor.jetbrains.space/p/edu/repositories/hazelcast-demo") {
            tags("version1.0")
        }
    }
}
