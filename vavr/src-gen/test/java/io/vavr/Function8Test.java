/*  __    __  __  __    __  ___
 * \  \  /  /    \  \  /  /  __/
 *  \  \/  /  /\  \  \/  /  /
 *   \____/__/  \__\____/__/
 *
 * Copyright 2014-2025 Vavr, https://vavr.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.vavr;

/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-*\
   G E N E R A T O R   C R A F T E D
\*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-*/

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.vavr.control.Try;
import java.lang.CharSequence;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Function8Test {

    @Test
    public void shouldCreateFromMethodReference() {
        class Type {
            Object methodReference(Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8) {
                return null;
            }
        }
        final Type type = new Type();
        assertThat(Function8.of(type::methodReference)).isNotNull();
    }

    @Test
    public void shouldLiftPartialFunction() {
        assertThat(Function8.lift((o1, o2, o3, o4, o5, o6, o7, o8) -> { while(true); })).isNotNull();
    }

    @Test
    public void shouldPartiallyApply() {
        final Function8<Object, Object, Object, Object, Object, Object, Object, Object, Object> f = (o1, o2, o3, o4, o5, o6, o7, o8) -> null;
        assertThat(f.apply(null)).isNotNull();
        assertThat(f.apply(null, null)).isNotNull();
        assertThat(f.apply(null, null, null)).isNotNull();
        assertThat(f.apply(null, null, null, null)).isNotNull();
        assertThat(f.apply(null, null, null, null, null)).isNotNull();
        assertThat(f.apply(null, null, null, null, null, null)).isNotNull();
        assertThat(f.apply(null, null, null, null, null, null, null)).isNotNull();
    }

    @Test
    public void shouldGetArity() {
        final Function8<Object, Object, Object, Object, Object, Object, Object, Object, Object> f = (o1, o2, o3, o4, o5, o6, o7, o8) -> null;
        assertThat(f.arity()).isEqualTo(8);
    }

    @Test
    public void shouldConstant() {
        final Function8<Object, Object, Object, Object, Object, Object, Object, Object, Object> f = Function8.constant(6);
        assertThat(f.apply(1, 2, 3, 4, 5, 6, 7, 8)).isEqualTo(6);
    }

    @Test
    public void shouldCurry() {
        final Function8<Object, Object, Object, Object, Object, Object, Object, Object, Object> f = (o1, o2, o3, o4, o5, o6, o7, o8) -> null;
        final Function1<Object, Function1<Object, Function1<Object, Function1<Object, Function1<Object, Function1<Object, Function1<Object, Function1<Object, Object>>>>>>>> curried = f.curried();
        assertThat(curried).isNotNull();
    }

    @Test
    public void shouldTuple() {
        final Function8<Object, Object, Object, Object, Object, Object, Object, Object, Object> f = (o1, o2, o3, o4, o5, o6, o7, o8) -> null;
        final Function1<Tuple8<Object, Object, Object, Object, Object, Object, Object, Object>, Object> tupled = f.tupled();
        assertThat(tupled).isNotNull();
    }

    @Test
    public void shouldReverse() {
        final Function8<Object, Object, Object, Object, Object, Object, Object, Object, Object> f = (o1, o2, o3, o4, o5, o6, o7, o8) -> null;
        assertThat(f.reversed()).isNotNull();
    }

    @Test
    public void shouldMemoize() {
        final AtomicInteger integer = new AtomicInteger();
        final Function8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> f = (i1, i2, i3, i4, i5, i6, i7, i8) -> i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + integer.getAndIncrement();
        final Function8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> memo = f.memoized();
        // should apply f on first apply()
        final int expected = memo.apply(1, 2, 3, 4, 5, 6, 7, 8);
        // should return memoized value of second apply()
        assertThat(memo.apply(1, 2, 3, 4, 5, 6, 7, 8)).isEqualTo(expected);
        // should calculate new values when called subsequently with different parameters
        assertThat(memo.apply(2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 )).isEqualTo(2  + 3  + 4  + 5  + 6  + 7  + 8  + 9  + 1);
        // should return memoized value of second apply() (for new value)
        assertThat(memo.apply(2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 )).isEqualTo(2  + 3  + 4  + 5  + 6  + 7  + 8  + 9  + 1);
    }

    @Test
    public void shouldNotMemoizeAlreadyMemoizedFunction() {
        final Function8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> f = (i1, i2, i3, i4, i5, i6, i7, i8) -> null;
        final Function8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> memo = f.memoized();
        assertThat(memo.memoized() == memo).isTrue();
    }

    @Test
    public void shouldMemoizeValueGivenNullArguments() {
        final Function8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> f = (i1, i2, i3, i4, i5, i6, i7, i8) -> null;
        final Function8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> memo = f.memoized();
        assertThat(memo.apply(null, null, null, null, null, null, null, null)).isNull();
    }

    @Test
    public void shouldRecognizeMemoizedFunctions() {
        final Function8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> f = (i1, i2, i3, i4, i5, i6, i7, i8) -> null;
        final Function8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> memo = f.memoized();
        assertThat(f.isMemoized()).isFalse();
        assertThat(memo.isMemoized()).isTrue();
    }

    @Test
    public void shouldLiftTryPartialFunction() {
        AtomicInteger integer = new AtomicInteger();
        Function8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> divByZero = (i1, i2, i3, i4, i5, i6, i7, i8) -> 10 / integer.get();
        Function8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Try<Integer>> divByZeroTry = Function8.liftTry(divByZero);

        Try<Integer> res = divByZeroTry.apply(0, 0, 0, 0, 0, 0, 0, 0);
        assertThat(res.isFailure()).isTrue();
        assertThat(res.getCause()).isNotNull();
        assertThat(res.getCause().getMessage()).isEqualToIgnoringCase("/ by zero");

        integer.incrementAndGet();
        res = divByZeroTry.apply(1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(res.isSuccess()).isTrue();
        assertThat(res.get()).isEqualTo(10);
    }

    private static final Function8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> recurrent1 = (i1, i2, i3, i4, i5, i6, i7, i8) -> i1 <= 0 ? i1 : Function8Test.recurrent2.apply(i1 - 1, i2, i3, i4, i5, i6, i7, i8) + 1;
    private static final Function8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> recurrent2 = Function8Test.recurrent1.memoized();

    @Test
    public void shouldCalculatedRecursively() {
        assertThat(recurrent1.apply(11, 11, 11, 11, 11, 11, 11, 11)).isEqualTo(11);
        assertThat(recurrent1.apply(22, 22, 22, 22, 22, 22, 22, 22)).isEqualTo(22);
    }

    @Test
    public void shouldComposeWithAndThen() {
        final Function8<Object, Object, Object, Object, Object, Object, Object, Object, Object> f = (o1, o2, o3, o4, o5, o6, o7, o8) -> null;
        final Function1<Object, Object> after = o -> null;
        final Function8<Object, Object, Object, Object, Object, Object, Object, Object, Object> composed = f.andThen(after);
        assertThat(composed).isNotNull();
    }

    @Nested
    class ComposeTests {

      @Test
      public void shouldCompose1() {
          final Function8<String, String, String, String, String, String, String, String, String> concat = (String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) -> s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8;
          final Function1<String, String> toUpperCase = String::toUpperCase;
          assertThat(concat.compose1(toUpperCase).apply("xx", "s2", "s3", "s4", "s5", "s6", "s7", "s8")).isEqualTo("XXs2s3s4s5s6s7s8");
      }

      @Test
      public void shouldCompose2() {
          final Function8<String, String, String, String, String, String, String, String, String> concat = (String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) -> s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8;
          final Function1<String, String> toUpperCase = String::toUpperCase;
          assertThat(concat.compose2(toUpperCase).apply("s1", "xx", "s3", "s4", "s5", "s6", "s7", "s8")).isEqualTo("s1XXs3s4s5s6s7s8");
      }

      @Test
      public void shouldCompose3() {
          final Function8<String, String, String, String, String, String, String, String, String> concat = (String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) -> s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8;
          final Function1<String, String> toUpperCase = String::toUpperCase;
          assertThat(concat.compose3(toUpperCase).apply("s1", "s2", "xx", "s4", "s5", "s6", "s7", "s8")).isEqualTo("s1s2XXs4s5s6s7s8");
      }

      @Test
      public void shouldCompose4() {
          final Function8<String, String, String, String, String, String, String, String, String> concat = (String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) -> s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8;
          final Function1<String, String> toUpperCase = String::toUpperCase;
          assertThat(concat.compose4(toUpperCase).apply("s1", "s2", "s3", "xx", "s5", "s6", "s7", "s8")).isEqualTo("s1s2s3XXs5s6s7s8");
      }

      @Test
      public void shouldCompose5() {
          final Function8<String, String, String, String, String, String, String, String, String> concat = (String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) -> s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8;
          final Function1<String, String> toUpperCase = String::toUpperCase;
          assertThat(concat.compose5(toUpperCase).apply("s1", "s2", "s3", "s4", "xx", "s6", "s7", "s8")).isEqualTo("s1s2s3s4XXs6s7s8");
      }

      @Test
      public void shouldCompose6() {
          final Function8<String, String, String, String, String, String, String, String, String> concat = (String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) -> s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8;
          final Function1<String, String> toUpperCase = String::toUpperCase;
          assertThat(concat.compose6(toUpperCase).apply("s1", "s2", "s3", "s4", "s5", "xx", "s7", "s8")).isEqualTo("s1s2s3s4s5XXs7s8");
      }

      @Test
      public void shouldCompose7() {
          final Function8<String, String, String, String, String, String, String, String, String> concat = (String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) -> s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8;
          final Function1<String, String> toUpperCase = String::toUpperCase;
          assertThat(concat.compose7(toUpperCase).apply("s1", "s2", "s3", "s4", "s5", "s6", "xx", "s8")).isEqualTo("s1s2s3s4s5s6XXs8");
      }

      @Test
      public void shouldCompose8() {
          final Function8<String, String, String, String, String, String, String, String, String> concat = (String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) -> s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8;
          final Function1<String, String> toUpperCase = String::toUpperCase;
          assertThat(concat.compose8(toUpperCase).apply("s1", "s2", "s3", "s4", "s5", "s6", "s7", "xx")).isEqualTo("s1s2s3s4s5s6s7XX");
      }

    }

    @Test
    public void shouldNarrow(){
        final Function8<Number, Number, Number, Number, Number, Number, Number, Number, String> wideFunction = (o1, o2, o3, o4, o5, o6, o7, o8) -> String.format("Numbers are: %s, %s, %s, %s, %s, %s, %s, %s", o1, o2, o3, o4, o5, o6, o7, o8);
        final Function8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, CharSequence> narrowFunction = Function8.narrow(wideFunction);

        assertThat(narrowFunction.apply(1, 2, 3, 4, 5, 6, 7, 8)).isEqualTo("Numbers are: 1, 2, 3, 4, 5, 6, 7, 8");
    }
}