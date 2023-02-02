package com.example.sozlukuygulamam

class Kelimelerdao {

    fun tumKelimeler (vt:VeritabaniYardimcisi) : ArrayList<Kelimeler>{
        val kelimelerListe = ArrayList<Kelimeler>()
        val db = vt.writableDatabase
        val c = db.rawQuery("SELECT * FROM kelimeler",null)

        while (c.moveToNext()){
            val kelime = Kelimeler(c.getInt(c.getColumnIndexOrThrow("kelime_id"))
                ,c.getString(c.getColumnIndexOrThrow("ingilizce"))
                ,c.getString(c.getColumnIndexOrThrow("turkce")))
            kelimelerListe.add(kelime)
        }
        return kelimelerListe
    }


    fun aramaYap (vt:VeritabaniYardimcisi,aramaKelime:String) : ArrayList<Kelimeler>{
        val kelimelerListe = ArrayList<Kelimeler>()
        val db = vt.writableDatabase
        val c = db.rawQuery("SELECT * FROM kelimeler WHERE ingilizce like '%$aramaKelime%'",null)

        while (c.moveToNext()){
            val kelime = Kelimeler(c.getInt(c.getColumnIndexOrThrow("kelime_id"))
                ,c.getString(c.getColumnIndexOrThrow("ingilizce"))
                ,c.getString(c.getColumnIndexOrThrow("turkce")))
            kelimelerListe.add(kelime)
        }
        return kelimelerListe
    }
}