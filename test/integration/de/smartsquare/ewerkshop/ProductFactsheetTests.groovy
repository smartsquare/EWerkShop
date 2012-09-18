package de.smartsquare.ewerkshop

import com.mongodb.Mongo
import de.flapdoodle.embed.mongo.MongodExecutable
import de.flapdoodle.embed.mongo.MongodStarter
import de.flapdoodle.embed.mongo.config.MongodConfig
import de.flapdoodle.embed.mongo.distribution.Version
import de.flapdoodle.embed.process.runtime.Network
import org.junit.After
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue

class ProductFactsheetTests {

    def static mongodProcess

    @BeforeClass
    static void setUpClass() {
        int port = 19321
        MongodConfig mongodConfig = new MongodConfig(Version.Main.V2_2, port, Network.localhostIsIPv6());

        MongodStarter runtime = MongodStarter.getDefaultInstance();
        MongodExecutable mongodExecutable = runtime.prepare(mongodConfig);
        mongodProcess = mongodExecutable.start();
    }

    @AfterClass
    static void tearDownClass() {
        if (mongodProcess) {
            mongodProcess.stop()
        }
    }

    @After
    void setupTest() {
        Mongo mongo = new Mongo("localhost", 19321)
        mongo.dropDatabase("integration_tests")
    }

    @Test
    void testPersistAndRetrieveWithStaticAttributesOnly() {
        // given
        ProductFactsheet facts = new ProductFactsheet(productId: 111, operatingVoltage: 220, powerInput: 400)
        facts.save(flush: true, failOnError: true)

        // when
        ProductFactsheet factsReloaded = ProductFactsheet.findByProductId(111)

        // then
        assertEquals("Saved and retrieved objects aren't equal", facts, factsReloaded)
    }

    @Test
    void testPersistAndRetrieveWithDynamicAttributesAlso() {
        assertTrue(ProductFactsheet.findAll().isEmpty())
        // given
        ProductFactsheet facts = new ProductFactsheet(productId: 111, operatingVoltage: 220, powerInput: 400)
        facts['dynamicFoo'] = 'Bar'
        facts.save(flush: true, failOnError: true)

        // when
        ProductFactsheet factsReloaded = ProductFactsheet.findByProductId(111)

        // then
        assertEquals("Saved and retrieved objects aren't equal", facts, factsReloaded)
        assertEquals("Dynamic attribute not enclosed in retrieved object", 'Bar', factsReloaded['dynamicFoo'])
    }
}
