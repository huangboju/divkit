@file:Suppress(
    "unused",
    "UNUSED_PARAMETER",
)

package divkit.dsl

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonValue
import divkit.dsl.annotation.*
import divkit.dsl.core.*
import divkit.dsl.scope.*
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map

/**
 * Pager. It contains a horizontal set of cards that can be scrolled page by page. It shows the main page and the beginning of the next one.
 * 
 * Can be created using the method [pager].
 * 
 * Required parameters: `type, layout_mode, items`.
 */
@Generated
class Pager internal constructor(
    @JsonIgnore
    val properties: Properties,
) : Div {
    @JsonAnyGetter
    internal fun getJsonProperties(): Map<String, Any> = properties.mergeWith(
        mapOf("type" to "pager")
    )

    operator fun plus(additive: Properties): Pager = Pager(
        Properties(
            accessibility = additive.accessibility ?: properties.accessibility,
            alignmentHorizontal = additive.alignmentHorizontal ?: properties.alignmentHorizontal,
            alignmentVertical = additive.alignmentVertical ?: properties.alignmentVertical,
            alpha = additive.alpha ?: properties.alpha,
            background = additive.background ?: properties.background,
            border = additive.border ?: properties.border,
            columnSpan = additive.columnSpan ?: properties.columnSpan,
            defaultItem = additive.defaultItem ?: properties.defaultItem,
            disappearActions = additive.disappearActions ?: properties.disappearActions,
            extensions = additive.extensions ?: properties.extensions,
            focus = additive.focus ?: properties.focus,
            height = additive.height ?: properties.height,
            id = additive.id ?: properties.id,
            itemSpacing = additive.itemSpacing ?: properties.itemSpacing,
            items = additive.items ?: properties.items,
            layoutMode = additive.layoutMode ?: properties.layoutMode,
            margins = additive.margins ?: properties.margins,
            orientation = additive.orientation ?: properties.orientation,
            paddings = additive.paddings ?: properties.paddings,
            restrictParentScroll = additive.restrictParentScroll ?: properties.restrictParentScroll,
            rowSpan = additive.rowSpan ?: properties.rowSpan,
            selectedActions = additive.selectedActions ?: properties.selectedActions,
            tooltips = additive.tooltips ?: properties.tooltips,
            transform = additive.transform ?: properties.transform,
            transitionChange = additive.transitionChange ?: properties.transitionChange,
            transitionIn = additive.transitionIn ?: properties.transitionIn,
            transitionOut = additive.transitionOut ?: properties.transitionOut,
            transitionTriggers = additive.transitionTriggers ?: properties.transitionTriggers,
            visibility = additive.visibility ?: properties.visibility,
            visibilityAction = additive.visibilityAction ?: properties.visibilityAction,
            visibilityActions = additive.visibilityActions ?: properties.visibilityActions,
            width = additive.width ?: properties.width,
        )
    )

    class Properties internal constructor(
        /**
         * Accessibility settings.
         */
        val accessibility: Property<Accessibility>?,
        /**
         * Horizontal alignment of an element inside the parent element.
         */
        val alignmentHorizontal: Property<AlignmentHorizontal>?,
        /**
         * Vertical alignment of an element inside the parent element.
         */
        val alignmentVertical: Property<AlignmentVertical>?,
        /**
         * Sets transparency of the entire element: `0` — completely transparent, `1` — opaque.
         * Default value: `1.0`.
         */
        val alpha: Property<Double>?,
        /**
         * Element background. It can contain multiple layers.
         */
        val background: Property<List<Background>>?,
        /**
         * Element stroke.
         */
        val border: Property<Border>?,
        /**
         * Merges cells in a column of the [grid](div-grid.md) element.
         */
        val columnSpan: Property<Int>?,
        /**
         * Ordinal number of the pager element that will be opened by default.
         * Default value: `0`.
         */
        val defaultItem: Property<Int>?,
        /**
         * Actions when an element disappears from the screen.
         */
        val disappearActions: Property<List<DisappearAction>>?,
        /**
         * Extensions for additional processing of an element. The list of extensions is given in  [DivExtension](../../extensions.dita).
         */
        val extensions: Property<List<Extension>>?,
        /**
         * Parameters when focusing on an element or losing focus.
         */
        val focus: Property<Focus>?,
        /**
         * Element height. For Android: if there is text in this or in a child element, specify height in `sp` to scale the element together with the text. To learn more about units of size measurement, see [Layout inside the card](../../layout.dita).
         * Default value: `{"type": "wrap_content"}`.
         */
        val height: Property<Size>?,
        /**
         * Element ID. It must be unique within the root element. It is used as `accessibilityIdentifier` on iOS.
         */
        val id: Property<String>?,
        /**
         * Spacing between elements.
         * Default value: `{"type": "fixed","value":0}`.
         */
        val itemSpacing: Property<FixedSize>?,
        /**
         * Pager elements. Page-by-page transition options can be implemented using:<li>`div-action://set_current_item?id=&item=` — set the current page with an ordinal number `item` inside an element, with the specified `id`;</li><li>`div-action://set_next_item?id=[&overflow={clamp|ring}]` — go to the next page inside an element, with the specified `id`;</li><li>`div-action://set_previous_item?id=[&overflow={clamp|ring}]` — go to the previous page inside an element, with the specified `id`.</li></p><p>The optional `overflow` parameter is used to set navigation when the first or last element is reached:<li>`clamp` — transition will stop at the border element;</li><li>`ring` — go to the beginning or end, depending on the current element.</li></p><p>By default, `clamp`.
         */
        val items: Property<List<Div>>?,
        /**
         * Type of calculation of the main page width:<li>`fixed` — from the fixed width of the next page `neighbour_page_width`;</li><li>`percentage` — from the percentage value `page_width`.</li>
         */
        val layoutMode: Property<PagerLayoutMode>?,
        /**
         * External margins from the element stroke.
         */
        val margins: Property<EdgeInsets>?,
        /**
         * Pager orientation.
         * Default value: `horizontal`.
         */
        val orientation: Property<Orientation>?,
        /**
         * Internal margins from the element stroke.
         */
        val paddings: Property<EdgeInsets>?,
        /**
         * If the parameter is enabled, the pager won't transmit the scroll gesture to the parent element.
         * Default value: `false`.
         */
        val restrictParentScroll: Property<Boolean>?,
        /**
         * Merges cells in a string of the [grid](div-grid.md) element.
         */
        val rowSpan: Property<Int>?,
        /**
         * List of [actions](div-action.md) to be executed when selecting an element in [pager](div-pager.md).
         */
        val selectedActions: Property<List<Action>>?,
        /**
         * Tooltips linked to an element. A tooltip can be shown by `div-action://show_tooltip?id=`, hidden by `div-action://hide_tooltip?id=` where `id` — tooltip id.
         */
        val tooltips: Property<List<Tooltip>>?,
        /**
         * Applies the passed transformation to the element. Content that doesn't fit into the original view area is cut off.
         */
        val transform: Property<Transform>?,
        /**
         * Change animation. It is played when the position or size of an element changes in the new layout.
         */
        val transitionChange: Property<ChangeTransition>?,
        /**
         * Appearance animation. It is played when an element with a new ID appears. To learn more about the concept of transitions, see [Animated transitions](../../interaction.dita#animation/transition-animation).
         */
        val transitionIn: Property<AppearanceTransition>?,
        /**
         * Disappearance animation. It is played when an element disappears in the new layout.
         */
        val transitionOut: Property<AppearanceTransition>?,
        /**
         * Animation starting triggers. Default value: `[state_change, visibility_change]`.
         */
        val transitionTriggers: Property<List<TransitionTrigger>>?,
        /**
         * Element visibility.
         * Default value: `visible`.
         */
        val visibility: Property<Visibility>?,
        /**
         * Tracking visibility of a single element. Not used if the `visibility_actions` parameter is set.
         */
        val visibilityAction: Property<VisibilityAction>?,
        /**
         * Actions when an element appears on the screen.
         */
        val visibilityActions: Property<List<VisibilityAction>>?,
        /**
         * Element width.
         * Default value: `{"type": "match_parent"}`.
         */
        val width: Property<Size>?,
    ) {
        internal fun mergeWith(properties: Map<String, Any>): Map<String, Any> {
            val result = mutableMapOf<String, Any>()
            result.putAll(properties)
            result.tryPutProperty("accessibility", accessibility)
            result.tryPutProperty("alignment_horizontal", alignmentHorizontal)
            result.tryPutProperty("alignment_vertical", alignmentVertical)
            result.tryPutProperty("alpha", alpha)
            result.tryPutProperty("background", background)
            result.tryPutProperty("border", border)
            result.tryPutProperty("column_span", columnSpan)
            result.tryPutProperty("default_item", defaultItem)
            result.tryPutProperty("disappear_actions", disappearActions)
            result.tryPutProperty("extensions", extensions)
            result.tryPutProperty("focus", focus)
            result.tryPutProperty("height", height)
            result.tryPutProperty("id", id)
            result.tryPutProperty("item_spacing", itemSpacing)
            result.tryPutProperty("items", items)
            result.tryPutProperty("layout_mode", layoutMode)
            result.tryPutProperty("margins", margins)
            result.tryPutProperty("orientation", orientation)
            result.tryPutProperty("paddings", paddings)
            result.tryPutProperty("restrict_parent_scroll", restrictParentScroll)
            result.tryPutProperty("row_span", rowSpan)
            result.tryPutProperty("selected_actions", selectedActions)
            result.tryPutProperty("tooltips", tooltips)
            result.tryPutProperty("transform", transform)
            result.tryPutProperty("transition_change", transitionChange)
            result.tryPutProperty("transition_in", transitionIn)
            result.tryPutProperty("transition_out", transitionOut)
            result.tryPutProperty("transition_triggers", transitionTriggers)
            result.tryPutProperty("visibility", visibility)
            result.tryPutProperty("visibility_action", visibilityAction)
            result.tryPutProperty("visibility_actions", visibilityActions)
            result.tryPutProperty("width", width)
            return result
        }
    }

    /**
     * Pager orientation.
     * 
     * Possible values: [horizontal, vertical].
     */
    @Generated
    sealed interface Orientation
}

/**
 * @param accessibility Accessibility settings.
 * @param alignmentHorizontal Horizontal alignment of an element inside the parent element.
 * @param alignmentVertical Vertical alignment of an element inside the parent element.
 * @param alpha Sets transparency of the entire element: `0` — completely transparent, `1` — opaque.
 * @param background Element background. It can contain multiple layers.
 * @param border Element stroke.
 * @param columnSpan Merges cells in a column of the [grid](div-grid.md) element.
 * @param defaultItem Ordinal number of the pager element that will be opened by default.
 * @param disappearActions Actions when an element disappears from the screen.
 * @param extensions Extensions for additional processing of an element. The list of extensions is given in  [DivExtension](../../extensions.dita).
 * @param focus Parameters when focusing on an element or losing focus.
 * @param height Element height. For Android: if there is text in this or in a child element, specify height in `sp` to scale the element together with the text. To learn more about units of size measurement, see [Layout inside the card](../../layout.dita).
 * @param id Element ID. It must be unique within the root element. It is used as `accessibilityIdentifier` on iOS.
 * @param itemSpacing Spacing between elements.
 * @param items Pager elements. Page-by-page transition options can be implemented using:<li>`div-action://set_current_item?id=&item=` — set the current page with an ordinal number `item` inside an element, with the specified `id`;</li><li>`div-action://set_next_item?id=[&overflow={clamp|ring}]` — go to the next page inside an element, with the specified `id`;</li><li>`div-action://set_previous_item?id=[&overflow={clamp|ring}]` — go to the previous page inside an element, with the specified `id`.</li></p><p>The optional `overflow` parameter is used to set navigation when the first or last element is reached:<li>`clamp` — transition will stop at the border element;</li><li>`ring` — go to the beginning or end, depending on the current element.</li></p><p>By default, `clamp`.
 * @param layoutMode Type of calculation of the main page width:<li>`fixed` — from the fixed width of the next page `neighbour_page_width`;</li><li>`percentage` — from the percentage value `page_width`.</li>
 * @param margins External margins from the element stroke.
 * @param orientation Pager orientation.
 * @param paddings Internal margins from the element stroke.
 * @param restrictParentScroll If the parameter is enabled, the pager won't transmit the scroll gesture to the parent element.
 * @param rowSpan Merges cells in a string of the [grid](div-grid.md) element.
 * @param selectedActions List of [actions](div-action.md) to be executed when selecting an element in [pager](div-pager.md).
 * @param tooltips Tooltips linked to an element. A tooltip can be shown by `div-action://show_tooltip?id=`, hidden by `div-action://hide_tooltip?id=` where `id` — tooltip id.
 * @param transform Applies the passed transformation to the element. Content that doesn't fit into the original view area is cut off.
 * @param transitionChange Change animation. It is played when the position or size of an element changes in the new layout.
 * @param transitionIn Appearance animation. It is played when an element with a new ID appears. To learn more about the concept of transitions, see [Animated transitions](../../interaction.dita#animation/transition-animation).
 * @param transitionOut Disappearance animation. It is played when an element disappears in the new layout.
 * @param transitionTriggers Animation starting triggers. Default value: `[state_change, visibility_change]`.
 * @param visibility Element visibility.
 * @param visibilityAction Tracking visibility of a single element. Not used if the `visibility_actions` parameter is set.
 * @param visibilityActions Actions when an element appears on the screen.
 * @param width Element width.
 */
@Generated
fun DivScope.pager(
    `use named arguments`: Guard = Guard.instance,
    accessibility: Accessibility? = null,
    alignmentHorizontal: AlignmentHorizontal? = null,
    alignmentVertical: AlignmentVertical? = null,
    alpha: Double? = null,
    background: List<Background>? = null,
    border: Border? = null,
    columnSpan: Int? = null,
    defaultItem: Int? = null,
    disappearActions: List<DisappearAction>? = null,
    extensions: List<Extension>? = null,
    focus: Focus? = null,
    height: Size? = null,
    id: String? = null,
    itemSpacing: FixedSize? = null,
    items: List<Div>? = null,
    layoutMode: PagerLayoutMode? = null,
    margins: EdgeInsets? = null,
    orientation: Pager.Orientation? = null,
    paddings: EdgeInsets? = null,
    restrictParentScroll: Boolean? = null,
    rowSpan: Int? = null,
    selectedActions: List<Action>? = null,
    tooltips: List<Tooltip>? = null,
    transform: Transform? = null,
    transitionChange: ChangeTransition? = null,
    transitionIn: AppearanceTransition? = null,
    transitionOut: AppearanceTransition? = null,
    transitionTriggers: List<TransitionTrigger>? = null,
    visibility: Visibility? = null,
    visibilityAction: VisibilityAction? = null,
    visibilityActions: List<VisibilityAction>? = null,
    width: Size? = null,
): Pager = Pager(
    Pager.Properties(
        accessibility = valueOrNull(accessibility),
        alignmentHorizontal = valueOrNull(alignmentHorizontal),
        alignmentVertical = valueOrNull(alignmentVertical),
        alpha = valueOrNull(alpha),
        background = valueOrNull(background),
        border = valueOrNull(border),
        columnSpan = valueOrNull(columnSpan),
        defaultItem = valueOrNull(defaultItem),
        disappearActions = valueOrNull(disappearActions),
        extensions = valueOrNull(extensions),
        focus = valueOrNull(focus),
        height = valueOrNull(height),
        id = valueOrNull(id),
        itemSpacing = valueOrNull(itemSpacing),
        items = valueOrNull(items),
        layoutMode = valueOrNull(layoutMode),
        margins = valueOrNull(margins),
        orientation = valueOrNull(orientation),
        paddings = valueOrNull(paddings),
        restrictParentScroll = valueOrNull(restrictParentScroll),
        rowSpan = valueOrNull(rowSpan),
        selectedActions = valueOrNull(selectedActions),
        tooltips = valueOrNull(tooltips),
        transform = valueOrNull(transform),
        transitionChange = valueOrNull(transitionChange),
        transitionIn = valueOrNull(transitionIn),
        transitionOut = valueOrNull(transitionOut),
        transitionTriggers = valueOrNull(transitionTriggers),
        visibility = valueOrNull(visibility),
        visibilityAction = valueOrNull(visibilityAction),
        visibilityActions = valueOrNull(visibilityActions),
        width = valueOrNull(width),
    )
)

/**
 * @param accessibility Accessibility settings.
 * @param alignmentHorizontal Horizontal alignment of an element inside the parent element.
 * @param alignmentVertical Vertical alignment of an element inside the parent element.
 * @param alpha Sets transparency of the entire element: `0` — completely transparent, `1` — opaque.
 * @param background Element background. It can contain multiple layers.
 * @param border Element stroke.
 * @param columnSpan Merges cells in a column of the [grid](div-grid.md) element.
 * @param defaultItem Ordinal number of the pager element that will be opened by default.
 * @param disappearActions Actions when an element disappears from the screen.
 * @param extensions Extensions for additional processing of an element. The list of extensions is given in  [DivExtension](../../extensions.dita).
 * @param focus Parameters when focusing on an element or losing focus.
 * @param height Element height. For Android: if there is text in this or in a child element, specify height in `sp` to scale the element together with the text. To learn more about units of size measurement, see [Layout inside the card](../../layout.dita).
 * @param id Element ID. It must be unique within the root element. It is used as `accessibilityIdentifier` on iOS.
 * @param itemSpacing Spacing between elements.
 * @param items Pager elements. Page-by-page transition options can be implemented using:<li>`div-action://set_current_item?id=&item=` — set the current page with an ordinal number `item` inside an element, with the specified `id`;</li><li>`div-action://set_next_item?id=[&overflow={clamp|ring}]` — go to the next page inside an element, with the specified `id`;</li><li>`div-action://set_previous_item?id=[&overflow={clamp|ring}]` — go to the previous page inside an element, with the specified `id`.</li></p><p>The optional `overflow` parameter is used to set navigation when the first or last element is reached:<li>`clamp` — transition will stop at the border element;</li><li>`ring` — go to the beginning or end, depending on the current element.</li></p><p>By default, `clamp`.
 * @param layoutMode Type of calculation of the main page width:<li>`fixed` — from the fixed width of the next page `neighbour_page_width`;</li><li>`percentage` — from the percentage value `page_width`.</li>
 * @param margins External margins from the element stroke.
 * @param orientation Pager orientation.
 * @param paddings Internal margins from the element stroke.
 * @param restrictParentScroll If the parameter is enabled, the pager won't transmit the scroll gesture to the parent element.
 * @param rowSpan Merges cells in a string of the [grid](div-grid.md) element.
 * @param selectedActions List of [actions](div-action.md) to be executed when selecting an element in [pager](div-pager.md).
 * @param tooltips Tooltips linked to an element. A tooltip can be shown by `div-action://show_tooltip?id=`, hidden by `div-action://hide_tooltip?id=` where `id` — tooltip id.
 * @param transform Applies the passed transformation to the element. Content that doesn't fit into the original view area is cut off.
 * @param transitionChange Change animation. It is played when the position or size of an element changes in the new layout.
 * @param transitionIn Appearance animation. It is played when an element with a new ID appears. To learn more about the concept of transitions, see [Animated transitions](../../interaction.dita#animation/transition-animation).
 * @param transitionOut Disappearance animation. It is played when an element disappears in the new layout.
 * @param transitionTriggers Animation starting triggers. Default value: `[state_change, visibility_change]`.
 * @param visibility Element visibility.
 * @param visibilityAction Tracking visibility of a single element. Not used if the `visibility_actions` parameter is set.
 * @param visibilityActions Actions when an element appears on the screen.
 * @param width Element width.
 */
@Generated
fun DivScope.pagerProps(
    `use named arguments`: Guard = Guard.instance,
    accessibility: Accessibility? = null,
    alignmentHorizontal: AlignmentHorizontal? = null,
    alignmentVertical: AlignmentVertical? = null,
    alpha: Double? = null,
    background: List<Background>? = null,
    border: Border? = null,
    columnSpan: Int? = null,
    defaultItem: Int? = null,
    disappearActions: List<DisappearAction>? = null,
    extensions: List<Extension>? = null,
    focus: Focus? = null,
    height: Size? = null,
    id: String? = null,
    itemSpacing: FixedSize? = null,
    items: List<Div>? = null,
    layoutMode: PagerLayoutMode? = null,
    margins: EdgeInsets? = null,
    orientation: Pager.Orientation? = null,
    paddings: EdgeInsets? = null,
    restrictParentScroll: Boolean? = null,
    rowSpan: Int? = null,
    selectedActions: List<Action>? = null,
    tooltips: List<Tooltip>? = null,
    transform: Transform? = null,
    transitionChange: ChangeTransition? = null,
    transitionIn: AppearanceTransition? = null,
    transitionOut: AppearanceTransition? = null,
    transitionTriggers: List<TransitionTrigger>? = null,
    visibility: Visibility? = null,
    visibilityAction: VisibilityAction? = null,
    visibilityActions: List<VisibilityAction>? = null,
    width: Size? = null,
) = Pager.Properties(
    accessibility = valueOrNull(accessibility),
    alignmentHorizontal = valueOrNull(alignmentHorizontal),
    alignmentVertical = valueOrNull(alignmentVertical),
    alpha = valueOrNull(alpha),
    background = valueOrNull(background),
    border = valueOrNull(border),
    columnSpan = valueOrNull(columnSpan),
    defaultItem = valueOrNull(defaultItem),
    disappearActions = valueOrNull(disappearActions),
    extensions = valueOrNull(extensions),
    focus = valueOrNull(focus),
    height = valueOrNull(height),
    id = valueOrNull(id),
    itemSpacing = valueOrNull(itemSpacing),
    items = valueOrNull(items),
    layoutMode = valueOrNull(layoutMode),
    margins = valueOrNull(margins),
    orientation = valueOrNull(orientation),
    paddings = valueOrNull(paddings),
    restrictParentScroll = valueOrNull(restrictParentScroll),
    rowSpan = valueOrNull(rowSpan),
    selectedActions = valueOrNull(selectedActions),
    tooltips = valueOrNull(tooltips),
    transform = valueOrNull(transform),
    transitionChange = valueOrNull(transitionChange),
    transitionIn = valueOrNull(transitionIn),
    transitionOut = valueOrNull(transitionOut),
    transitionTriggers = valueOrNull(transitionTriggers),
    visibility = valueOrNull(visibility),
    visibilityAction = valueOrNull(visibilityAction),
    visibilityActions = valueOrNull(visibilityActions),
    width = valueOrNull(width),
)

/**
 * @param accessibility Accessibility settings.
 * @param alignmentHorizontal Horizontal alignment of an element inside the parent element.
 * @param alignmentVertical Vertical alignment of an element inside the parent element.
 * @param alpha Sets transparency of the entire element: `0` — completely transparent, `1` — opaque.
 * @param background Element background. It can contain multiple layers.
 * @param border Element stroke.
 * @param columnSpan Merges cells in a column of the [grid](div-grid.md) element.
 * @param defaultItem Ordinal number of the pager element that will be opened by default.
 * @param disappearActions Actions when an element disappears from the screen.
 * @param extensions Extensions for additional processing of an element. The list of extensions is given in  [DivExtension](../../extensions.dita).
 * @param focus Parameters when focusing on an element or losing focus.
 * @param height Element height. For Android: if there is text in this or in a child element, specify height in `sp` to scale the element together with the text. To learn more about units of size measurement, see [Layout inside the card](../../layout.dita).
 * @param id Element ID. It must be unique within the root element. It is used as `accessibilityIdentifier` on iOS.
 * @param itemSpacing Spacing between elements.
 * @param items Pager elements. Page-by-page transition options can be implemented using:<li>`div-action://set_current_item?id=&item=` — set the current page with an ordinal number `item` inside an element, with the specified `id`;</li><li>`div-action://set_next_item?id=[&overflow={clamp|ring}]` — go to the next page inside an element, with the specified `id`;</li><li>`div-action://set_previous_item?id=[&overflow={clamp|ring}]` — go to the previous page inside an element, with the specified `id`.</li></p><p>The optional `overflow` parameter is used to set navigation when the first or last element is reached:<li>`clamp` — transition will stop at the border element;</li><li>`ring` — go to the beginning or end, depending on the current element.</li></p><p>By default, `clamp`.
 * @param layoutMode Type of calculation of the main page width:<li>`fixed` — from the fixed width of the next page `neighbour_page_width`;</li><li>`percentage` — from the percentage value `page_width`.</li>
 * @param margins External margins from the element stroke.
 * @param orientation Pager orientation.
 * @param paddings Internal margins from the element stroke.
 * @param restrictParentScroll If the parameter is enabled, the pager won't transmit the scroll gesture to the parent element.
 * @param rowSpan Merges cells in a string of the [grid](div-grid.md) element.
 * @param selectedActions List of [actions](div-action.md) to be executed when selecting an element in [pager](div-pager.md).
 * @param tooltips Tooltips linked to an element. A tooltip can be shown by `div-action://show_tooltip?id=`, hidden by `div-action://hide_tooltip?id=` where `id` — tooltip id.
 * @param transform Applies the passed transformation to the element. Content that doesn't fit into the original view area is cut off.
 * @param transitionChange Change animation. It is played when the position or size of an element changes in the new layout.
 * @param transitionIn Appearance animation. It is played when an element with a new ID appears. To learn more about the concept of transitions, see [Animated transitions](../../interaction.dita#animation/transition-animation).
 * @param transitionOut Disappearance animation. It is played when an element disappears in the new layout.
 * @param transitionTriggers Animation starting triggers. Default value: `[state_change, visibility_change]`.
 * @param visibility Element visibility.
 * @param visibilityAction Tracking visibility of a single element. Not used if the `visibility_actions` parameter is set.
 * @param visibilityActions Actions when an element appears on the screen.
 * @param width Element width.
 */
@Generated
fun TemplateScope.pagerRefs(
    `use named arguments`: Guard = Guard.instance,
    accessibility: ReferenceProperty<Accessibility>? = null,
    alignmentHorizontal: ReferenceProperty<AlignmentHorizontal>? = null,
    alignmentVertical: ReferenceProperty<AlignmentVertical>? = null,
    alpha: ReferenceProperty<Double>? = null,
    background: ReferenceProperty<List<Background>>? = null,
    border: ReferenceProperty<Border>? = null,
    columnSpan: ReferenceProperty<Int>? = null,
    defaultItem: ReferenceProperty<Int>? = null,
    disappearActions: ReferenceProperty<List<DisappearAction>>? = null,
    extensions: ReferenceProperty<List<Extension>>? = null,
    focus: ReferenceProperty<Focus>? = null,
    height: ReferenceProperty<Size>? = null,
    id: ReferenceProperty<String>? = null,
    itemSpacing: ReferenceProperty<FixedSize>? = null,
    items: ReferenceProperty<List<Div>>? = null,
    layoutMode: ReferenceProperty<PagerLayoutMode>? = null,
    margins: ReferenceProperty<EdgeInsets>? = null,
    orientation: ReferenceProperty<Pager.Orientation>? = null,
    paddings: ReferenceProperty<EdgeInsets>? = null,
    restrictParentScroll: ReferenceProperty<Boolean>? = null,
    rowSpan: ReferenceProperty<Int>? = null,
    selectedActions: ReferenceProperty<List<Action>>? = null,
    tooltips: ReferenceProperty<List<Tooltip>>? = null,
    transform: ReferenceProperty<Transform>? = null,
    transitionChange: ReferenceProperty<ChangeTransition>? = null,
    transitionIn: ReferenceProperty<AppearanceTransition>? = null,
    transitionOut: ReferenceProperty<AppearanceTransition>? = null,
    transitionTriggers: ReferenceProperty<List<TransitionTrigger>>? = null,
    visibility: ReferenceProperty<Visibility>? = null,
    visibilityAction: ReferenceProperty<VisibilityAction>? = null,
    visibilityActions: ReferenceProperty<List<VisibilityAction>>? = null,
    width: ReferenceProperty<Size>? = null,
) = Pager.Properties(
    accessibility = accessibility,
    alignmentHorizontal = alignmentHorizontal,
    alignmentVertical = alignmentVertical,
    alpha = alpha,
    background = background,
    border = border,
    columnSpan = columnSpan,
    defaultItem = defaultItem,
    disappearActions = disappearActions,
    extensions = extensions,
    focus = focus,
    height = height,
    id = id,
    itemSpacing = itemSpacing,
    items = items,
    layoutMode = layoutMode,
    margins = margins,
    orientation = orientation,
    paddings = paddings,
    restrictParentScroll = restrictParentScroll,
    rowSpan = rowSpan,
    selectedActions = selectedActions,
    tooltips = tooltips,
    transform = transform,
    transitionChange = transitionChange,
    transitionIn = transitionIn,
    transitionOut = transitionOut,
    transitionTriggers = transitionTriggers,
    visibility = visibility,
    visibilityAction = visibilityAction,
    visibilityActions = visibilityActions,
    width = width,
)

/**
 * @param accessibility Accessibility settings.
 * @param alignmentHorizontal Horizontal alignment of an element inside the parent element.
 * @param alignmentVertical Vertical alignment of an element inside the parent element.
 * @param alpha Sets transparency of the entire element: `0` — completely transparent, `1` — opaque.
 * @param background Element background. It can contain multiple layers.
 * @param border Element stroke.
 * @param columnSpan Merges cells in a column of the [grid](div-grid.md) element.
 * @param defaultItem Ordinal number of the pager element that will be opened by default.
 * @param disappearActions Actions when an element disappears from the screen.
 * @param extensions Extensions for additional processing of an element. The list of extensions is given in  [DivExtension](../../extensions.dita).
 * @param focus Parameters when focusing on an element or losing focus.
 * @param height Element height. For Android: if there is text in this or in a child element, specify height in `sp` to scale the element together with the text. To learn more about units of size measurement, see [Layout inside the card](../../layout.dita).
 * @param id Element ID. It must be unique within the root element. It is used as `accessibilityIdentifier` on iOS.
 * @param itemSpacing Spacing between elements.
 * @param items Pager elements. Page-by-page transition options can be implemented using:<li>`div-action://set_current_item?id=&item=` — set the current page with an ordinal number `item` inside an element, with the specified `id`;</li><li>`div-action://set_next_item?id=[&overflow={clamp|ring}]` — go to the next page inside an element, with the specified `id`;</li><li>`div-action://set_previous_item?id=[&overflow={clamp|ring}]` — go to the previous page inside an element, with the specified `id`.</li></p><p>The optional `overflow` parameter is used to set navigation when the first or last element is reached:<li>`clamp` — transition will stop at the border element;</li><li>`ring` — go to the beginning or end, depending on the current element.</li></p><p>By default, `clamp`.
 * @param layoutMode Type of calculation of the main page width:<li>`fixed` — from the fixed width of the next page `neighbour_page_width`;</li><li>`percentage` — from the percentage value `page_width`.</li>
 * @param margins External margins from the element stroke.
 * @param orientation Pager orientation.
 * @param paddings Internal margins from the element stroke.
 * @param restrictParentScroll If the parameter is enabled, the pager won't transmit the scroll gesture to the parent element.
 * @param rowSpan Merges cells in a string of the [grid](div-grid.md) element.
 * @param selectedActions List of [actions](div-action.md) to be executed when selecting an element in [pager](div-pager.md).
 * @param tooltips Tooltips linked to an element. A tooltip can be shown by `div-action://show_tooltip?id=`, hidden by `div-action://hide_tooltip?id=` where `id` — tooltip id.
 * @param transform Applies the passed transformation to the element. Content that doesn't fit into the original view area is cut off.
 * @param transitionChange Change animation. It is played when the position or size of an element changes in the new layout.
 * @param transitionIn Appearance animation. It is played when an element with a new ID appears. To learn more about the concept of transitions, see [Animated transitions](../../interaction.dita#animation/transition-animation).
 * @param transitionOut Disappearance animation. It is played when an element disappears in the new layout.
 * @param transitionTriggers Animation starting triggers. Default value: `[state_change, visibility_change]`.
 * @param visibility Element visibility.
 * @param visibilityAction Tracking visibility of a single element. Not used if the `visibility_actions` parameter is set.
 * @param visibilityActions Actions when an element appears on the screen.
 * @param width Element width.
 */
@Generated
fun Pager.override(
    `use named arguments`: Guard = Guard.instance,
    accessibility: Accessibility? = null,
    alignmentHorizontal: AlignmentHorizontal? = null,
    alignmentVertical: AlignmentVertical? = null,
    alpha: Double? = null,
    background: List<Background>? = null,
    border: Border? = null,
    columnSpan: Int? = null,
    defaultItem: Int? = null,
    disappearActions: List<DisappearAction>? = null,
    extensions: List<Extension>? = null,
    focus: Focus? = null,
    height: Size? = null,
    id: String? = null,
    itemSpacing: FixedSize? = null,
    items: List<Div>? = null,
    layoutMode: PagerLayoutMode? = null,
    margins: EdgeInsets? = null,
    orientation: Pager.Orientation? = null,
    paddings: EdgeInsets? = null,
    restrictParentScroll: Boolean? = null,
    rowSpan: Int? = null,
    selectedActions: List<Action>? = null,
    tooltips: List<Tooltip>? = null,
    transform: Transform? = null,
    transitionChange: ChangeTransition? = null,
    transitionIn: AppearanceTransition? = null,
    transitionOut: AppearanceTransition? = null,
    transitionTriggers: List<TransitionTrigger>? = null,
    visibility: Visibility? = null,
    visibilityAction: VisibilityAction? = null,
    visibilityActions: List<VisibilityAction>? = null,
    width: Size? = null,
): Pager = Pager(
    Pager.Properties(
        accessibility = valueOrNull(accessibility) ?: properties.accessibility,
        alignmentHorizontal = valueOrNull(alignmentHorizontal) ?: properties.alignmentHorizontal,
        alignmentVertical = valueOrNull(alignmentVertical) ?: properties.alignmentVertical,
        alpha = valueOrNull(alpha) ?: properties.alpha,
        background = valueOrNull(background) ?: properties.background,
        border = valueOrNull(border) ?: properties.border,
        columnSpan = valueOrNull(columnSpan) ?: properties.columnSpan,
        defaultItem = valueOrNull(defaultItem) ?: properties.defaultItem,
        disappearActions = valueOrNull(disappearActions) ?: properties.disappearActions,
        extensions = valueOrNull(extensions) ?: properties.extensions,
        focus = valueOrNull(focus) ?: properties.focus,
        height = valueOrNull(height) ?: properties.height,
        id = valueOrNull(id) ?: properties.id,
        itemSpacing = valueOrNull(itemSpacing) ?: properties.itemSpacing,
        items = valueOrNull(items) ?: properties.items,
        layoutMode = valueOrNull(layoutMode) ?: properties.layoutMode,
        margins = valueOrNull(margins) ?: properties.margins,
        orientation = valueOrNull(orientation) ?: properties.orientation,
        paddings = valueOrNull(paddings) ?: properties.paddings,
        restrictParentScroll = valueOrNull(restrictParentScroll) ?: properties.restrictParentScroll,
        rowSpan = valueOrNull(rowSpan) ?: properties.rowSpan,
        selectedActions = valueOrNull(selectedActions) ?: properties.selectedActions,
        tooltips = valueOrNull(tooltips) ?: properties.tooltips,
        transform = valueOrNull(transform) ?: properties.transform,
        transitionChange = valueOrNull(transitionChange) ?: properties.transitionChange,
        transitionIn = valueOrNull(transitionIn) ?: properties.transitionIn,
        transitionOut = valueOrNull(transitionOut) ?: properties.transitionOut,
        transitionTriggers = valueOrNull(transitionTriggers) ?: properties.transitionTriggers,
        visibility = valueOrNull(visibility) ?: properties.visibility,
        visibilityAction = valueOrNull(visibilityAction) ?: properties.visibilityAction,
        visibilityActions = valueOrNull(visibilityActions) ?: properties.visibilityActions,
        width = valueOrNull(width) ?: properties.width,
    )
)

/**
 * @param accessibility Accessibility settings.
 * @param alignmentHorizontal Horizontal alignment of an element inside the parent element.
 * @param alignmentVertical Vertical alignment of an element inside the parent element.
 * @param alpha Sets transparency of the entire element: `0` — completely transparent, `1` — opaque.
 * @param background Element background. It can contain multiple layers.
 * @param border Element stroke.
 * @param columnSpan Merges cells in a column of the [grid](div-grid.md) element.
 * @param defaultItem Ordinal number of the pager element that will be opened by default.
 * @param disappearActions Actions when an element disappears from the screen.
 * @param extensions Extensions for additional processing of an element. The list of extensions is given in  [DivExtension](../../extensions.dita).
 * @param focus Parameters when focusing on an element or losing focus.
 * @param height Element height. For Android: if there is text in this or in a child element, specify height in `sp` to scale the element together with the text. To learn more about units of size measurement, see [Layout inside the card](../../layout.dita).
 * @param id Element ID. It must be unique within the root element. It is used as `accessibilityIdentifier` on iOS.
 * @param itemSpacing Spacing between elements.
 * @param items Pager elements. Page-by-page transition options can be implemented using:<li>`div-action://set_current_item?id=&item=` — set the current page with an ordinal number `item` inside an element, with the specified `id`;</li><li>`div-action://set_next_item?id=[&overflow={clamp|ring}]` — go to the next page inside an element, with the specified `id`;</li><li>`div-action://set_previous_item?id=[&overflow={clamp|ring}]` — go to the previous page inside an element, with the specified `id`.</li></p><p>The optional `overflow` parameter is used to set navigation when the first or last element is reached:<li>`clamp` — transition will stop at the border element;</li><li>`ring` — go to the beginning or end, depending on the current element.</li></p><p>By default, `clamp`.
 * @param layoutMode Type of calculation of the main page width:<li>`fixed` — from the fixed width of the next page `neighbour_page_width`;</li><li>`percentage` — from the percentage value `page_width`.</li>
 * @param margins External margins from the element stroke.
 * @param orientation Pager orientation.
 * @param paddings Internal margins from the element stroke.
 * @param restrictParentScroll If the parameter is enabled, the pager won't transmit the scroll gesture to the parent element.
 * @param rowSpan Merges cells in a string of the [grid](div-grid.md) element.
 * @param selectedActions List of [actions](div-action.md) to be executed when selecting an element in [pager](div-pager.md).
 * @param tooltips Tooltips linked to an element. A tooltip can be shown by `div-action://show_tooltip?id=`, hidden by `div-action://hide_tooltip?id=` where `id` — tooltip id.
 * @param transform Applies the passed transformation to the element. Content that doesn't fit into the original view area is cut off.
 * @param transitionChange Change animation. It is played when the position or size of an element changes in the new layout.
 * @param transitionIn Appearance animation. It is played when an element with a new ID appears. To learn more about the concept of transitions, see [Animated transitions](../../interaction.dita#animation/transition-animation).
 * @param transitionOut Disappearance animation. It is played when an element disappears in the new layout.
 * @param transitionTriggers Animation starting triggers. Default value: `[state_change, visibility_change]`.
 * @param visibility Element visibility.
 * @param visibilityAction Tracking visibility of a single element. Not used if the `visibility_actions` parameter is set.
 * @param visibilityActions Actions when an element appears on the screen.
 * @param width Element width.
 */
@Generated
fun Pager.defer(
    `use named arguments`: Guard = Guard.instance,
    accessibility: ReferenceProperty<Accessibility>? = null,
    alignmentHorizontal: ReferenceProperty<AlignmentHorizontal>? = null,
    alignmentVertical: ReferenceProperty<AlignmentVertical>? = null,
    alpha: ReferenceProperty<Double>? = null,
    background: ReferenceProperty<List<Background>>? = null,
    border: ReferenceProperty<Border>? = null,
    columnSpan: ReferenceProperty<Int>? = null,
    defaultItem: ReferenceProperty<Int>? = null,
    disappearActions: ReferenceProperty<List<DisappearAction>>? = null,
    extensions: ReferenceProperty<List<Extension>>? = null,
    focus: ReferenceProperty<Focus>? = null,
    height: ReferenceProperty<Size>? = null,
    id: ReferenceProperty<String>? = null,
    itemSpacing: ReferenceProperty<FixedSize>? = null,
    items: ReferenceProperty<List<Div>>? = null,
    layoutMode: ReferenceProperty<PagerLayoutMode>? = null,
    margins: ReferenceProperty<EdgeInsets>? = null,
    orientation: ReferenceProperty<Pager.Orientation>? = null,
    paddings: ReferenceProperty<EdgeInsets>? = null,
    restrictParentScroll: ReferenceProperty<Boolean>? = null,
    rowSpan: ReferenceProperty<Int>? = null,
    selectedActions: ReferenceProperty<List<Action>>? = null,
    tooltips: ReferenceProperty<List<Tooltip>>? = null,
    transform: ReferenceProperty<Transform>? = null,
    transitionChange: ReferenceProperty<ChangeTransition>? = null,
    transitionIn: ReferenceProperty<AppearanceTransition>? = null,
    transitionOut: ReferenceProperty<AppearanceTransition>? = null,
    transitionTriggers: ReferenceProperty<List<TransitionTrigger>>? = null,
    visibility: ReferenceProperty<Visibility>? = null,
    visibilityAction: ReferenceProperty<VisibilityAction>? = null,
    visibilityActions: ReferenceProperty<List<VisibilityAction>>? = null,
    width: ReferenceProperty<Size>? = null,
): Pager = Pager(
    Pager.Properties(
        accessibility = accessibility ?: properties.accessibility,
        alignmentHorizontal = alignmentHorizontal ?: properties.alignmentHorizontal,
        alignmentVertical = alignmentVertical ?: properties.alignmentVertical,
        alpha = alpha ?: properties.alpha,
        background = background ?: properties.background,
        border = border ?: properties.border,
        columnSpan = columnSpan ?: properties.columnSpan,
        defaultItem = defaultItem ?: properties.defaultItem,
        disappearActions = disappearActions ?: properties.disappearActions,
        extensions = extensions ?: properties.extensions,
        focus = focus ?: properties.focus,
        height = height ?: properties.height,
        id = id ?: properties.id,
        itemSpacing = itemSpacing ?: properties.itemSpacing,
        items = items ?: properties.items,
        layoutMode = layoutMode ?: properties.layoutMode,
        margins = margins ?: properties.margins,
        orientation = orientation ?: properties.orientation,
        paddings = paddings ?: properties.paddings,
        restrictParentScroll = restrictParentScroll ?: properties.restrictParentScroll,
        rowSpan = rowSpan ?: properties.rowSpan,
        selectedActions = selectedActions ?: properties.selectedActions,
        tooltips = tooltips ?: properties.tooltips,
        transform = transform ?: properties.transform,
        transitionChange = transitionChange ?: properties.transitionChange,
        transitionIn = transitionIn ?: properties.transitionIn,
        transitionOut = transitionOut ?: properties.transitionOut,
        transitionTriggers = transitionTriggers ?: properties.transitionTriggers,
        visibility = visibility ?: properties.visibility,
        visibilityAction = visibilityAction ?: properties.visibilityAction,
        visibilityActions = visibilityActions ?: properties.visibilityActions,
        width = width ?: properties.width,
    )
)

/**
 * @param alignmentHorizontal Horizontal alignment of an element inside the parent element.
 * @param alignmentVertical Vertical alignment of an element inside the parent element.
 * @param alpha Sets transparency of the entire element: `0` — completely transparent, `1` — opaque.
 * @param columnSpan Merges cells in a column of the [grid](div-grid.md) element.
 * @param defaultItem Ordinal number of the pager element that will be opened by default.
 * @param orientation Pager orientation.
 * @param restrictParentScroll If the parameter is enabled, the pager won't transmit the scroll gesture to the parent element.
 * @param rowSpan Merges cells in a string of the [grid](div-grid.md) element.
 * @param visibility Element visibility.
 */
@Generated
fun Pager.evaluate(
    `use named arguments`: Guard = Guard.instance,
    alignmentHorizontal: ExpressionProperty<AlignmentHorizontal>? = null,
    alignmentVertical: ExpressionProperty<AlignmentVertical>? = null,
    alpha: ExpressionProperty<Double>? = null,
    columnSpan: ExpressionProperty<Int>? = null,
    defaultItem: ExpressionProperty<Int>? = null,
    orientation: ExpressionProperty<Pager.Orientation>? = null,
    restrictParentScroll: ExpressionProperty<Boolean>? = null,
    rowSpan: ExpressionProperty<Int>? = null,
    visibility: ExpressionProperty<Visibility>? = null,
): Pager = Pager(
    Pager.Properties(
        accessibility = properties.accessibility,
        alignmentHorizontal = alignmentHorizontal ?: properties.alignmentHorizontal,
        alignmentVertical = alignmentVertical ?: properties.alignmentVertical,
        alpha = alpha ?: properties.alpha,
        background = properties.background,
        border = properties.border,
        columnSpan = columnSpan ?: properties.columnSpan,
        defaultItem = defaultItem ?: properties.defaultItem,
        disappearActions = properties.disappearActions,
        extensions = properties.extensions,
        focus = properties.focus,
        height = properties.height,
        id = properties.id,
        itemSpacing = properties.itemSpacing,
        items = properties.items,
        layoutMode = properties.layoutMode,
        margins = properties.margins,
        orientation = orientation ?: properties.orientation,
        paddings = properties.paddings,
        restrictParentScroll = restrictParentScroll ?: properties.restrictParentScroll,
        rowSpan = rowSpan ?: properties.rowSpan,
        selectedActions = properties.selectedActions,
        tooltips = properties.tooltips,
        transform = properties.transform,
        transitionChange = properties.transitionChange,
        transitionIn = properties.transitionIn,
        transitionOut = properties.transitionOut,
        transitionTriggers = properties.transitionTriggers,
        visibility = visibility ?: properties.visibility,
        visibilityAction = properties.visibilityAction,
        visibilityActions = properties.visibilityActions,
        width = properties.width,
    )
)

/**
 * @param accessibility Accessibility settings.
 * @param alignmentHorizontal Horizontal alignment of an element inside the parent element.
 * @param alignmentVertical Vertical alignment of an element inside the parent element.
 * @param alpha Sets transparency of the entire element: `0` — completely transparent, `1` — opaque.
 * @param background Element background. It can contain multiple layers.
 * @param border Element stroke.
 * @param columnSpan Merges cells in a column of the [grid](div-grid.md) element.
 * @param defaultItem Ordinal number of the pager element that will be opened by default.
 * @param disappearActions Actions when an element disappears from the screen.
 * @param extensions Extensions for additional processing of an element. The list of extensions is given in  [DivExtension](../../extensions.dita).
 * @param focus Parameters when focusing on an element or losing focus.
 * @param height Element height. For Android: if there is text in this or in a child element, specify height in `sp` to scale the element together with the text. To learn more about units of size measurement, see [Layout inside the card](../../layout.dita).
 * @param id Element ID. It must be unique within the root element. It is used as `accessibilityIdentifier` on iOS.
 * @param itemSpacing Spacing between elements.
 * @param items Pager elements. Page-by-page transition options can be implemented using:<li>`div-action://set_current_item?id=&item=` — set the current page with an ordinal number `item` inside an element, with the specified `id`;</li><li>`div-action://set_next_item?id=[&overflow={clamp|ring}]` — go to the next page inside an element, with the specified `id`;</li><li>`div-action://set_previous_item?id=[&overflow={clamp|ring}]` — go to the previous page inside an element, with the specified `id`.</li></p><p>The optional `overflow` parameter is used to set navigation when the first or last element is reached:<li>`clamp` — transition will stop at the border element;</li><li>`ring` — go to the beginning or end, depending on the current element.</li></p><p>By default, `clamp`.
 * @param layoutMode Type of calculation of the main page width:<li>`fixed` — from the fixed width of the next page `neighbour_page_width`;</li><li>`percentage` — from the percentage value `page_width`.</li>
 * @param margins External margins from the element stroke.
 * @param orientation Pager orientation.
 * @param paddings Internal margins from the element stroke.
 * @param restrictParentScroll If the parameter is enabled, the pager won't transmit the scroll gesture to the parent element.
 * @param rowSpan Merges cells in a string of the [grid](div-grid.md) element.
 * @param selectedActions List of [actions](div-action.md) to be executed when selecting an element in [pager](div-pager.md).
 * @param tooltips Tooltips linked to an element. A tooltip can be shown by `div-action://show_tooltip?id=`, hidden by `div-action://hide_tooltip?id=` where `id` — tooltip id.
 * @param transform Applies the passed transformation to the element. Content that doesn't fit into the original view area is cut off.
 * @param transitionChange Change animation. It is played when the position or size of an element changes in the new layout.
 * @param transitionIn Appearance animation. It is played when an element with a new ID appears. To learn more about the concept of transitions, see [Animated transitions](../../interaction.dita#animation/transition-animation).
 * @param transitionOut Disappearance animation. It is played when an element disappears in the new layout.
 * @param transitionTriggers Animation starting triggers. Default value: `[state_change, visibility_change]`.
 * @param visibility Element visibility.
 * @param visibilityAction Tracking visibility of a single element. Not used if the `visibility_actions` parameter is set.
 * @param visibilityActions Actions when an element appears on the screen.
 * @param width Element width.
 */
@Generated
fun Component<Pager>.override(
    `use named arguments`: Guard = Guard.instance,
    accessibility: Accessibility? = null,
    alignmentHorizontal: AlignmentHorizontal? = null,
    alignmentVertical: AlignmentVertical? = null,
    alpha: Double? = null,
    background: List<Background>? = null,
    border: Border? = null,
    columnSpan: Int? = null,
    defaultItem: Int? = null,
    disappearActions: List<DisappearAction>? = null,
    extensions: List<Extension>? = null,
    focus: Focus? = null,
    height: Size? = null,
    id: String? = null,
    itemSpacing: FixedSize? = null,
    items: List<Div>? = null,
    layoutMode: PagerLayoutMode? = null,
    margins: EdgeInsets? = null,
    orientation: Pager.Orientation? = null,
    paddings: EdgeInsets? = null,
    restrictParentScroll: Boolean? = null,
    rowSpan: Int? = null,
    selectedActions: List<Action>? = null,
    tooltips: List<Tooltip>? = null,
    transform: Transform? = null,
    transitionChange: ChangeTransition? = null,
    transitionIn: AppearanceTransition? = null,
    transitionOut: AppearanceTransition? = null,
    transitionTriggers: List<TransitionTrigger>? = null,
    visibility: Visibility? = null,
    visibilityAction: VisibilityAction? = null,
    visibilityActions: List<VisibilityAction>? = null,
    width: Size? = null,
): Component<Pager> = Component(
    template = template,
    properties = Pager.Properties(
        accessibility = valueOrNull(accessibility),
        alignmentHorizontal = valueOrNull(alignmentHorizontal),
        alignmentVertical = valueOrNull(alignmentVertical),
        alpha = valueOrNull(alpha),
        background = valueOrNull(background),
        border = valueOrNull(border),
        columnSpan = valueOrNull(columnSpan),
        defaultItem = valueOrNull(defaultItem),
        disappearActions = valueOrNull(disappearActions),
        extensions = valueOrNull(extensions),
        focus = valueOrNull(focus),
        height = valueOrNull(height),
        id = valueOrNull(id),
        itemSpacing = valueOrNull(itemSpacing),
        items = valueOrNull(items),
        layoutMode = valueOrNull(layoutMode),
        margins = valueOrNull(margins),
        orientation = valueOrNull(orientation),
        paddings = valueOrNull(paddings),
        restrictParentScroll = valueOrNull(restrictParentScroll),
        rowSpan = valueOrNull(rowSpan),
        selectedActions = valueOrNull(selectedActions),
        tooltips = valueOrNull(tooltips),
        transform = valueOrNull(transform),
        transitionChange = valueOrNull(transitionChange),
        transitionIn = valueOrNull(transitionIn),
        transitionOut = valueOrNull(transitionOut),
        transitionTriggers = valueOrNull(transitionTriggers),
        visibility = valueOrNull(visibility),
        visibilityAction = valueOrNull(visibilityAction),
        visibilityActions = valueOrNull(visibilityActions),
        width = valueOrNull(width),
    ).mergeWith(properties)
)

/**
 * @param accessibility Accessibility settings.
 * @param alignmentHorizontal Horizontal alignment of an element inside the parent element.
 * @param alignmentVertical Vertical alignment of an element inside the parent element.
 * @param alpha Sets transparency of the entire element: `0` — completely transparent, `1` — opaque.
 * @param background Element background. It can contain multiple layers.
 * @param border Element stroke.
 * @param columnSpan Merges cells in a column of the [grid](div-grid.md) element.
 * @param defaultItem Ordinal number of the pager element that will be opened by default.
 * @param disappearActions Actions when an element disappears from the screen.
 * @param extensions Extensions for additional processing of an element. The list of extensions is given in  [DivExtension](../../extensions.dita).
 * @param focus Parameters when focusing on an element or losing focus.
 * @param height Element height. For Android: if there is text in this or in a child element, specify height in `sp` to scale the element together with the text. To learn more about units of size measurement, see [Layout inside the card](../../layout.dita).
 * @param id Element ID. It must be unique within the root element. It is used as `accessibilityIdentifier` on iOS.
 * @param itemSpacing Spacing between elements.
 * @param items Pager elements. Page-by-page transition options can be implemented using:<li>`div-action://set_current_item?id=&item=` — set the current page with an ordinal number `item` inside an element, with the specified `id`;</li><li>`div-action://set_next_item?id=[&overflow={clamp|ring}]` — go to the next page inside an element, with the specified `id`;</li><li>`div-action://set_previous_item?id=[&overflow={clamp|ring}]` — go to the previous page inside an element, with the specified `id`.</li></p><p>The optional `overflow` parameter is used to set navigation when the first or last element is reached:<li>`clamp` — transition will stop at the border element;</li><li>`ring` — go to the beginning or end, depending on the current element.</li></p><p>By default, `clamp`.
 * @param layoutMode Type of calculation of the main page width:<li>`fixed` — from the fixed width of the next page `neighbour_page_width`;</li><li>`percentage` — from the percentage value `page_width`.</li>
 * @param margins External margins from the element stroke.
 * @param orientation Pager orientation.
 * @param paddings Internal margins from the element stroke.
 * @param restrictParentScroll If the parameter is enabled, the pager won't transmit the scroll gesture to the parent element.
 * @param rowSpan Merges cells in a string of the [grid](div-grid.md) element.
 * @param selectedActions List of [actions](div-action.md) to be executed when selecting an element in [pager](div-pager.md).
 * @param tooltips Tooltips linked to an element. A tooltip can be shown by `div-action://show_tooltip?id=`, hidden by `div-action://hide_tooltip?id=` where `id` — tooltip id.
 * @param transform Applies the passed transformation to the element. Content that doesn't fit into the original view area is cut off.
 * @param transitionChange Change animation. It is played when the position or size of an element changes in the new layout.
 * @param transitionIn Appearance animation. It is played when an element with a new ID appears. To learn more about the concept of transitions, see [Animated transitions](../../interaction.dita#animation/transition-animation).
 * @param transitionOut Disappearance animation. It is played when an element disappears in the new layout.
 * @param transitionTriggers Animation starting triggers. Default value: `[state_change, visibility_change]`.
 * @param visibility Element visibility.
 * @param visibilityAction Tracking visibility of a single element. Not used if the `visibility_actions` parameter is set.
 * @param visibilityActions Actions when an element appears on the screen.
 * @param width Element width.
 */
@Generated
fun Component<Pager>.defer(
    `use named arguments`: Guard = Guard.instance,
    accessibility: ReferenceProperty<Accessibility>? = null,
    alignmentHorizontal: ReferenceProperty<AlignmentHorizontal>? = null,
    alignmentVertical: ReferenceProperty<AlignmentVertical>? = null,
    alpha: ReferenceProperty<Double>? = null,
    background: ReferenceProperty<List<Background>>? = null,
    border: ReferenceProperty<Border>? = null,
    columnSpan: ReferenceProperty<Int>? = null,
    defaultItem: ReferenceProperty<Int>? = null,
    disappearActions: ReferenceProperty<List<DisappearAction>>? = null,
    extensions: ReferenceProperty<List<Extension>>? = null,
    focus: ReferenceProperty<Focus>? = null,
    height: ReferenceProperty<Size>? = null,
    id: ReferenceProperty<String>? = null,
    itemSpacing: ReferenceProperty<FixedSize>? = null,
    items: ReferenceProperty<List<Div>>? = null,
    layoutMode: ReferenceProperty<PagerLayoutMode>? = null,
    margins: ReferenceProperty<EdgeInsets>? = null,
    orientation: ReferenceProperty<Pager.Orientation>? = null,
    paddings: ReferenceProperty<EdgeInsets>? = null,
    restrictParentScroll: ReferenceProperty<Boolean>? = null,
    rowSpan: ReferenceProperty<Int>? = null,
    selectedActions: ReferenceProperty<List<Action>>? = null,
    tooltips: ReferenceProperty<List<Tooltip>>? = null,
    transform: ReferenceProperty<Transform>? = null,
    transitionChange: ReferenceProperty<ChangeTransition>? = null,
    transitionIn: ReferenceProperty<AppearanceTransition>? = null,
    transitionOut: ReferenceProperty<AppearanceTransition>? = null,
    transitionTriggers: ReferenceProperty<List<TransitionTrigger>>? = null,
    visibility: ReferenceProperty<Visibility>? = null,
    visibilityAction: ReferenceProperty<VisibilityAction>? = null,
    visibilityActions: ReferenceProperty<List<VisibilityAction>>? = null,
    width: ReferenceProperty<Size>? = null,
): Component<Pager> = Component(
    template = template,
    properties = Pager.Properties(
        accessibility = accessibility,
        alignmentHorizontal = alignmentHorizontal,
        alignmentVertical = alignmentVertical,
        alpha = alpha,
        background = background,
        border = border,
        columnSpan = columnSpan,
        defaultItem = defaultItem,
        disappearActions = disappearActions,
        extensions = extensions,
        focus = focus,
        height = height,
        id = id,
        itemSpacing = itemSpacing,
        items = items,
        layoutMode = layoutMode,
        margins = margins,
        orientation = orientation,
        paddings = paddings,
        restrictParentScroll = restrictParentScroll,
        rowSpan = rowSpan,
        selectedActions = selectedActions,
        tooltips = tooltips,
        transform = transform,
        transitionChange = transitionChange,
        transitionIn = transitionIn,
        transitionOut = transitionOut,
        transitionTriggers = transitionTriggers,
        visibility = visibility,
        visibilityAction = visibilityAction,
        visibilityActions = visibilityActions,
        width = width,
    ).mergeWith(properties)
)

/**
 * @param alignmentHorizontal Horizontal alignment of an element inside the parent element.
 * @param alignmentVertical Vertical alignment of an element inside the parent element.
 * @param alpha Sets transparency of the entire element: `0` — completely transparent, `1` — opaque.
 * @param columnSpan Merges cells in a column of the [grid](div-grid.md) element.
 * @param defaultItem Ordinal number of the pager element that will be opened by default.
 * @param orientation Pager orientation.
 * @param restrictParentScroll If the parameter is enabled, the pager won't transmit the scroll gesture to the parent element.
 * @param rowSpan Merges cells in a string of the [grid](div-grid.md) element.
 * @param visibility Element visibility.
 */
@Generated
fun Component<Pager>.evaluate(
    `use named arguments`: Guard = Guard.instance,
    alignmentHorizontal: ExpressionProperty<AlignmentHorizontal>? = null,
    alignmentVertical: ExpressionProperty<AlignmentVertical>? = null,
    alpha: ExpressionProperty<Double>? = null,
    columnSpan: ExpressionProperty<Int>? = null,
    defaultItem: ExpressionProperty<Int>? = null,
    orientation: ExpressionProperty<Pager.Orientation>? = null,
    restrictParentScroll: ExpressionProperty<Boolean>? = null,
    rowSpan: ExpressionProperty<Int>? = null,
    visibility: ExpressionProperty<Visibility>? = null,
): Component<Pager> = Component(
    template = template,
    properties = Pager.Properties(
        accessibility = null,
        alignmentHorizontal = alignmentHorizontal,
        alignmentVertical = alignmentVertical,
        alpha = alpha,
        background = null,
        border = null,
        columnSpan = columnSpan,
        defaultItem = defaultItem,
        disappearActions = null,
        extensions = null,
        focus = null,
        height = null,
        id = null,
        itemSpacing = null,
        items = null,
        layoutMode = null,
        margins = null,
        orientation = orientation,
        paddings = null,
        restrictParentScroll = restrictParentScroll,
        rowSpan = rowSpan,
        selectedActions = null,
        tooltips = null,
        transform = null,
        transitionChange = null,
        transitionIn = null,
        transitionOut = null,
        transitionTriggers = null,
        visibility = visibility,
        visibilityAction = null,
        visibilityActions = null,
        width = null,
    ).mergeWith(properties)
)

@Generated
operator fun Component<Pager>.plus(additive: Pager.Properties): Component<Pager> = Component(
    template = template,
    properties = additive.mergeWith(properties)
)

@Generated
fun Pager.asList() = listOf(this)

@Generated
fun Pager.Orientation.asList() = listOf(this)
