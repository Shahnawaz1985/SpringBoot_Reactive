package com.eric.spring.boot.tests.suites;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({"com.eric.spring.boot.slice.test"})
//@SelectClasses(value = {CartRepositorySliceTest.class, MongoDBSliceTest.class})
public class DBSliceTestSuite {

}
