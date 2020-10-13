package orbit.hello

import orbit.client.actor.ActorWithStringKey

interface Greeter : ActorWithStringKey {
    suspend fun sayHello(greeting:String): String
}