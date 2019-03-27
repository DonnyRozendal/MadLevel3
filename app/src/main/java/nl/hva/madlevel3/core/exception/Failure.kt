package nl.hva.madlevel3.core.exception

sealed class Failure {

    class DbInsertError(val exception: Exception) : BaseFailure()
    class DbQueryError(val exception: Exception) : BaseFailure()

    // Extend this for specific exceptions
    abstract class BaseFailure : Failure()
}