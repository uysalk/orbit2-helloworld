package orbit.hello

import kotlinx.coroutines.runBlocking
import orbit.client.OrbitClient
import orbit.client.OrbitClientConfig


fun main() {
    runBlocking {
        val orbitClient = OrbitClient(
            OrbitClientConfig(
                namespace = "hello",
                grpcEndpoint = "dns:///localhost:50056/"
            )
        )

        orbitClient.start().join()

        val greeter = orbitClient.actorFactory.createProxy<Greeter>(Greeter::class.java ,"Hi")
        val response = greeter.sayHello("Welcome to Orbit")
        println(response)

        orbitClient.stop().join()
    }
}