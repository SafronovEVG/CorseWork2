package com.safronovbr.corse2.impl;

import com.safronovbr.corse2.repository.QuestionRepository;
import com.safronovbr.corse2.service.impl.MathQuestionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceImplTest {
    @Mock
    private QuestionRepository questionRepository;

    private MathQuestionServiceImpl questionService;


    public static Stream<Arguments> ArgumentsForRandomQuestion() {
        return Stream.of(
                Arguments.of(0, 0, 0, 0),
                Arguments.of(1, 1, 1, 0),
                Arguments.of(2, 2, 2, 1),
                Arguments.of(3, 3, 3, 9)
        );
    }

    @BeforeEach
    public void setUp() {
        questionService = new MathQuestionServiceImpl(questionRepository);
    }

    @ParameterizedTest
    @MethodSource("ArgumentsForRandomQuestion")
    public void getQu(Integer arg, Integer first, Integer last, Integer result) {
        Integer expected = result;

        Integer actual = ReflectionTestUtils.invokeMethod(questionService, "getResult", arg, first, last);

        assertEquals(expected, actual);
    }
}