package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


public class PointTests {
    @Test

    public void testDistance() {
        Point p1 = new Point(1,3);
        Point p2 = new Point(1,7);
                Assert.assertEquals(p2.distance(p1),4.0);
        Point p3 = new Point(0,0);
        Point p4 = new Point(0,0);
        Assert.assertEquals(p3.distance(p4),0.0);
    }
}
