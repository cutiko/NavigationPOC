# NavigationPOC

Basically how to use the `popUpTo` and `popUpToInclusive`

```
FirstFragment -> SecondFragment -> ThirdFragment -onBackPressed-> FirstFragment
```

```
FirstFragment -> SecondFragment -> ThirdFragment -> FourthFragment -onBackPressed-> FirstFragment
```

## According to the documentation

The key is to understand what the resource id means in `popUpTo`. The [official documentation](https://developer.android.com/guide/navigation/navigation-navigate#pop) says:

> The attribute value is the ID of the most recent destination that should remain on the stack.

This means that `popUpTo` is equivalent of `removeEverythingUpToTheFollowingId`. So for example a navigation that is like this:

```
  <fragment
        android:id="@+id/ThirdFragment">
        <action
            android:id="@+id/action_ThirdFragment_to_FirstFragment"
            app:destination="@id/firstFragment"
            app:popUpTo="@id/firstFragment"
            app:popUpToInclusive="true"/>
    </fragment>
```

Will do this:

```
FirstFragment -> SecondFragment -> ThirdFragment -action_ThirdFragment_to_FirstFragment-> FirstFragment
```

Making the backstack something like this:

```
FirstFragment
```

Because is navigating to the `FirstFragment` from the third, and is removing every fragment from the stack up to the `firstFragment` including it.

In the same case if we change `app:popUpToInclusive="false"` the original `FirstFragment` will remain in the stack. So after navigating from the third to the first fragment, if the user press the back button, then it will navigate from the recently navigated first fragment to the original first fragment. Same navigation than above (from third to first), but the backstack is different:

```
FirstFragment (original not removed due to popUpToInclusive false) -> FirstFragment (navigate from the third using action_ThirdFragment_to_FirstFragment)
```

