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
- `docs(..)` --> skips github release, but creates a SNAPSHOT of the next PATCH version

[Full list of conventions](https://github.com/conventional-changelog-archived-repos/conventional-changelog-angular/blob/master/convention.md)

## Publishing source releases to GitHub

You must export `GH_TOKEN` environment variable to your environment with a [GitHub token](https://help.github.com/articles/creating-a-personal-access-token-for-the-command-line/)
as the value to be able to use the `release` task.

### TravisCI

Add the `GH_TOKEN` variable to your TravisCI pipeline.

On every push to the `master` branch, a release will take place. 

Refer to `.travis.yml` file on how to create a TravisCI pipeline configuration.