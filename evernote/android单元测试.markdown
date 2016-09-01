Title: Android单元测试
Tags: Android,Junit
Notebook: Android

[TOC]

# Espresso-Intents

> focus on validation and mocking of intents.

### 目录

```bash
app/src/androidTestMock/java
```

### 流程

1. **@Rule** set up '''IntentsTestRule'''

```java
@Rule
  public IntentsTestRule<AddNoteActivity> mAddNoteIntentsTestRule =
          new IntentsTestRule<>(AddNoteActivity.class);
```

2. **@before**

```java
@Before
   public void registerIdlingResource() {
       Espresso.registerIdlingResources(
               mAddNoteIntentsTestRule.getActivity().getCountingIdlingResource());
   }
```

3. **@Test**

```java
@Test
public void addImageToNote_ShowsThumbnailInUi() {
//        fail("Implement in step 8");
    // Create an Activity Result which can be used to stub the camera Intent
    ActivityResult result = createImageCaptureActivityResultStub();
    // If there is an Intent with ACTION_IMAGE_CAPTURE, intercept the Intent and respond with
    // a stubbed result.
    intending(hasAction(MediaStore.ACTION_IMAGE_CAPTURE)).respondWith(result);

    // Check thumbnail view is not displayed
    onView(withId(R.id.add_note_image_thumbnail)).check(matches(not(isDisplayed())));

    selectTakeImageFromMenu();

    // Check that the stubbed thumbnail is displayed in the UI
    onView(withId(R.id.add_note_image_thumbnail))
            .perform(scrollTo()) // Scroll to thumbnail
            .check(matches(allOf(
                    hasDrawable(), // Check ImageView has a drawable set with a custom matcher
                    isDisplayed())));
}
```

# Espresso-Contrib

> Test for navigation Drawer

确保使用Junit4 runner 以及指定large test:

```java
@RunWith(AndroidJUnit4.class)
@LargeTest
public class AppNavigationTest {
...
}
```

>
  * **@SmallTest**: <100ms 执行时间,频繁run，only use local dependencies, no resource access
  * **@MediumTest**: <2s,focus on limited subset of app components, no external resource access, mocking external dependencies
  * **@LargeTest**: >2s.
