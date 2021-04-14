/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.idcards.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.openmrs.module.idcards.IdcardsTemplate;
import org.openmrs.module.idcards.db.IdcardsDAO;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IdcardsServiceImplTest {

    @Mock
    private IdcardsDAO dao;

    private IdcardsServiceImpl idcardsService;

    @Before
    public void setup() {
        idcardsService = new IdcardsServiceImpl();
        idcardsService.setIdcardsDAO(dao);
    }

    @Test
    public void shouldGetIdCardsTemplate() {
        IdcardsTemplate template = mock(IdcardsTemplate.class);
        when(template.getTemplateId()).thenReturn(1);
        when(dao.getIdcardsTemplate(1)).thenReturn(template);

        IdcardsTemplate resultTemplate = idcardsService.getIdcardsTemplate(1);

        assertThat(resultTemplate, notNullValue());
        assertThat(resultTemplate.getTemplateId(), is(1));
    }
}