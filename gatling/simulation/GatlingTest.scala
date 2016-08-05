package gatling.simultion

/**
 * Created by swati on 20/7/16.
 */

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._

class GatlingTest extends Simulation {

  val httpConf = http
    .baseURL("http://www.facebook.com") // Here is the root for all relative URLs


  val scn = scenario("Test Facebook") // A scenario is a chain of requests and pauses
    .exec(http("facebook")
      .get("/")
      .check(status.is(200)))
    .pause(7) // Note that Gatling has recorded real time pauses



  setUp(scn.inject(atOnceUsers(10)).protocols(httpConf))
}