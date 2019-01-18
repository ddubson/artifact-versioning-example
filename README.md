# Artifact Versioning and Publishing Example

## Structured Git versioning using Semantic Versioning

In a traditional semantic versioning scheme, there exists a standard pattern of versioning:

```
MAJOR.MINOR.PATCH
```

[gradle-semantic-release-plugin](https://github.com/tschulte/gradle-semantic-release-plugin) uses 
this strategy to apply to Git commits

Here are ways to apply a version update on each commit

If a commit starts with:

- `fix(..)` --> bumps PATCH
- `docs(..)` --> creates a SNAPSHOT of the next PATCH version

[Full list of conventions](https://github.com/conventional-changelog-archived-repos/conventional-changelog-angular/blob/master/convention.md)