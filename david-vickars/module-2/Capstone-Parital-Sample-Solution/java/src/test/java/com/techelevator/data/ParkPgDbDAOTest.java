package com.techelevator.data;

import com.techelevator.entity.Campground;
import com.techelevator.entity.Money;
import com.techelevator.entity.Park;
import com.techelevator.entity.Site;
import org.junit.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ParkPgDbDAOTest extends DAOIntegrationTest {

    private ParkDaoJDBC subject;

    private Park expectedPark;

    private List<Campground> expectedCampgrounds;

    @Before
    public void setUp() throws Exception {
        subject = new ParkDaoJDBC(getDataSource());

        expectedPark = new Park(1, "Acadia", "Maine",
                LocalDate.parse("1919-02-26"),
                47389, 2563129L);
        expectedCampgrounds = new ArrayList<>(3);
        expectedCampgrounds.add(new Campground(
                1, "Blackwoods","01", "12", new Money(35.0), expectedPark));
        expectedCampgrounds.add(new Campground(
                2, "Seawall","05", "09", new Money(30.0), expectedPark));
        expectedCampgrounds.add(new Campground(
                3, "Blackwoods","05", "10", new Money(30.0), expectedPark));
        expectedPark.setCampgrounds(expectedCampgrounds);
    }

    @Test
    public void getParksTest() {
        List<Park> parks = subject.getParks(false);
        assertEquals("Count of parks ", 3, parks.size());
    }

    @Test
    public void getParkByPkTest() {
        Park actualPark = subject.getParkByPk(1, false);
        assertEquals("Primary key ", 1, actualPark.getId());
    }

    @Test
    public void getParkByPkDataTest() {
        Park actualPark = subject.getParkByPk(1, true);
        assertEquals(expectedPark, actualPark);
    }

    @Test
    public void getParkByPkCascadeCountTest() {
        Park actualPark = subject.getParkByPk(1, true);
        assertEquals("Count of campgrounds ", 3, actualPark.getCampgrounds().size());
    }

    @Test
    public void getParkByPkCascadeDataTest() {
        Park actualPark = subject.getParkByPk(1, true);
        assertEquals(3, actualPark.getCampgrounds().size());
        assertEquals(276, actualPark.getCampgrounds().get(0).getSites().size());
        assertEquals(2, actualPark.getCampgrounds().get(0).getSites().get(0).getReservations().size());
    }

    @Test
    public void getParkCampgroundsTest() {
        List<Campground> campgrounds = subject.getCampgroundsForPark(1,false);
        assertEquals("Count of campgrounds ", 3, campgrounds.size());
    }

    @Test
    public void getAvailableSitesTest() {
        List<Site> sites = subject.getAvailableSites(expectedCampgrounds.get(0),
                LocalDate.parse("2019-10-14"), LocalDate.parse("2019-10-20"));
        assertEquals("Count of available sites ", 264, sites.size());
    }
}