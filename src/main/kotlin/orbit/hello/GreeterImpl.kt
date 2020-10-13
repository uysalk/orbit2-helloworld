package orbit.hello

import orbit.client.actor.AbstractActor

class GreeterImpl : AbstractActor(), Greeter {

    override suspend fun sayHello(greeting: String): String {

        println("Here: $greeting")
        return "You said: '$greeting', I say: 'Hello from ${context.reference.key} at node ${context.client.nodeId?.key}!'"
    }
}
