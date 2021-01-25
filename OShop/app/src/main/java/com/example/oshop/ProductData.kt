package com.example.oshop

object ProductData {

    private val productNames = arrayOf("Pot Bibit Warna-Warni",
            "Paket Refill Kit Hidroponik",
            "Pupuk Organik Siap Pakai",
            "Benih Sayur Selada, Kemangi, Kangkung, Sawi, Bayam",
            "Kit Menanam/Berkebun Hidroponik",
            "Set Sekop Mini",
            "Kit Menanam Microgreen",
            "Label Penanda Tanaman"
    )

    private val productImages = intArrayOf(R.drawable.pot_bibit,
        R.drawable.refill_hidroponik,
        R.drawable.pupuk_organik,
        R.drawable.benih,
        R.drawable.kit_hidroponik,
        R.drawable.sekop_mini,
        R.drawable.kit_microgreen,
        R.drawable.label_tancap
    )

    private val productPrice = arrayOf("Rp2.500",
            "Rp11.000",
            "Rp25.000",
            "Rp1.500 ~ Rp10.000",
            "Rp30.000 ~ Rp34.000",
            "Rp6.000",
            "Rp12.500",
            "Rp600"
    )

    private val productSold = arrayOf("29",
            "20",
            "50",
            "76",
            "9",
            "5",
            "14",
            "15"
    )

    private val productStock = arrayOf("300",
            "98",
            "56",
            "100",
            "324",
            "140",
            "150",
            "800"
    )

    private val productSize = arrayOf("10cm",
            "",
            "",
            "",
            "18x12x10",
            "5x20",
            "10x8x10",
            "5x8"
    )

    private val productMaterial = arrayOf("Plastik",
            "Sayuran",
            "Sayuran",
            "Sayuran",
            "Plastik",
            "Kayu dan besi",
            "Plastik",
            "Plastik"
    )

    private val productDetail = arrayOf("Minimal order 5 pc dan bisa pilih warna.",
            "Paket refill untuk kit hidroponik sawi/selada/kemangi/bayam. Bisa untuk 4 kali tanam. Terdiri dari: \n 1. 1 bungkus ab mix untuk 100ml air \n 2. 18 kotak rockwool \n 3. 1 bungkus benih \n 4. Box untuk packing",
            "Siap pakai, tinggal disemprot. Terbuat dari bahan alami dan mengandung N, P, K, Ca, Mg, Fe, Mn, B, Cu, Zn dll \n" +
                    "Cara Pakai: 7-10 hari sekali.",
            "Masa tanam: \n" +
                    "1. Bayam & Kangkung +- 25 hari\n" +
                    "2. Selada, Kemangi, Sawi, Pakcoy +- 45 hari",
            "Kit hidroponik untuk menanam Sawi, Selada, Bayam atau Kemangi untuk 2 kali tanam.\n" +
                    "Kit terdiri dari: \n 1. 1 buah baskom \n 2. 1 buah tutup dengan lubang netpot \n 3. 3 buah netpot \n 4. 3 buah kain flanel untuk netpot",
            "Cocok untuk berkebun di pot/polybag atau di tanah langsung. Memudahkan memindahkan semaian ke polybag.",
            "Microgreen adalah tumbuhan yang dipanen diusianya yang muda. Kandungan nutrisi tanaman sayur saat masih muda berdasarkan penelitian, lebih tinggi daripada tanaman sayur ketika dewasa",
            "Biasa digunakan untuk memberi nama tanaman, waktu tanam dll."
    )

    val listProduct: ArrayList<Product>
        get(){
            val list = arrayListOf<Product>()
            for (position in productNames.indices){
                val product = Product()
                product.name = productNames[position]
                product.price = productPrice[position]
                product.sold = productSold[position]
                product.stock = productStock[position]
                product.size = productSize[position]
                product.material = productMaterial [position]
                product.detail = productDetail[position]
                product.photo = productImages[position]
                list.add(product)
            }
            return list
        }
}