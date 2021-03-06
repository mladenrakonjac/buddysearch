package com.buddysearch.android.domain.interactor.user;

import com.buddysearch.android.domain.interactor.BaseUseCaseTest;
import com.buddysearch.android.domain.repository.UserRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import rx.functions.Action0;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GetUsersTest extends BaseUseCaseTest<GetUsers, UserRepository> {

    @Override
    protected GetUsers createUseCase() {
        return new GetUsers(mockRepository, mockMessenger, mockThreadScheduler, mockPostExecutionScheduler);
    }

    @Override
    protected UserRepository createRepository() {
        return mock(UserRepository.class);
    }

    @Test
    @Override
    public void testBuildUseCaseObservable() {
        testBuildUseCaseObservable(null, new Action0() {
            @Override
            public void call() {
                verify(mockRepository).getUsers(mockMessenger);
            }
        });
    }
}
