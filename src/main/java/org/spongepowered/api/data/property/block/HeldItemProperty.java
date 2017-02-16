/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.data.property.block;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.data.Property;
import org.spongepowered.api.data.property.AbstractProperty;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.Coerce;

/**
 * A property that provides the {@link ItemType} representation of what a
 * {@link BlockState} or {@link BlockType} may present itself if it was
 * represented as an {@link ItemStack}.
 */
public class HeldItemProperty extends AbstractProperty<String, ItemType> {

    /**
     * Creates a new {@link HeldItemProperty} with the provided {@link ItemType}.
     *
     * @param value The item type value for the block
     */
    public HeldItemProperty(ItemType value) {
        super(value);
    }

    /**
     * Creates a new {@link HeldItemProperty} with the provided {@link ItemType}
     * and {@link Operator comparison operator}.
     *
     * @param value The item value
     * @param op The operator for comparisons
     */
    public HeldItemProperty(ItemType value, Operator op) {
        super(value, op);
    }

    @Override
    public int compareTo(Property<?, ?> o) {
        return this.getValue().getId().compareTo(o == null ? "" : Coerce.toString(o.getValue()));
    }
}
