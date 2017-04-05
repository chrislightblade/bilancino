/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author tss
 */
public class FunzioniData {

    public static LocalDate converti(Date date) {
        Instant toInstant = date.toInstant();
        return LocalDate.from(toInstant);
    }

    public static Date converti(LocalDate date) {
        return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
