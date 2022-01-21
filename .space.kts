

job("Build and push Docker") {
    docker {
        build {
            context = "hazelcast-demo"
            file = "./Dockerfile"
            labels["vendor"] = "netmoor"
            args["HTTP_PROXY"] = "http://10.20.30.1:123"
        }

        push("netmoor.registry.jetbrains.space/p/edu/containers/hzk-demo") {
            tags(tags("0.0.run_number"))
        }
    }
}
