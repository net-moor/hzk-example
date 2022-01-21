

job("Build and push Docker") {
    docker {
        build {
            context = "docker"
            file = "./docker/Dockerfile"
            args["HTTP_PROXY"] = "http://10.20.30.2:1234"
            labels["vendor"] = "netmoor"
        }

        push("mycompany.registry.jetbrains.space/p/projectkey/mydocker/myimage") {
            // use current job run number as a tag - '0.0.run_number'
            tags("0.0.run_number")
            // see example on how to use branch name in a tag
        }
    }
}