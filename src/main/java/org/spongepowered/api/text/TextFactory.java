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
package org.spongepowered.api.text;

import org.spongepowered.api.scoreboard.Score;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextFormat;
import org.spongepowered.api.text.format.TextStyle;
import org.spongepowered.api.text.selector.Selector;
import org.spongepowered.api.text.serializer.FormattingCodeTextSerializer;

import java.util.Iterator;

public interface TextFactory {
    // Text

    Text emptyText();

    LiteralText literal(final char content);

    LiteralText literal(final String content);

    ScoreText score(final Score score);

    SelectorText selector(final Selector selector);

    Text of(final Object... args);

    Text joinWith(final Text separator, final Text... texts);

    Text joinWith(final Text separator, final Iterator<? extends Text> texts);

    // Format

    TextFormat emptyFormat();

    TextFormat format(final TextColor color, final TextStyle style);

    // Template

    TextTemplate emptyTemplate();

    TextTemplate template(String openArg, String closeArg, Object[] elements);

    // Serializer

    /**
     * Returns a representation that accepts and outputs legacy color codes,
     * using the provided legacy character.
     *
     * @param legacyChar The legacy character to parse and output using
     * @return The appropriate legacy representation handler
     */
    FormattingCodeTextSerializer createFormattingCodeSerializer(char legacyChar);
}
