package li.mercury.tushare.internal.extension

/**
 * A marker annotations for DSLs.
 */
@DslMarker
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPEALIAS, AnnotationTarget.TYPE, AnnotationTarget.FUNCTION)
annotation class TuShareDsl
